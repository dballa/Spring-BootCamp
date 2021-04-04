package com.academy.monika.restapp.repository;

import com.academy.monika.restapp.entity.SubjectEntity;
import com.academy.monika.restapp.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class SubjectRepository {

    @Autowired
    private EntityManager entityManager;
    public SubjectRepository(EntityManager em) {
        super();
        this.entityManager = em;
    }


    private static final String GET_LIST = "SELECT subject from SubjectEntity subject where 1=1 ";


    public SubjectEntity getSubjectById(long id) {
        TypedQuery<SubjectEntity> query = entityManager.createQuery("SELECT sub from SubjectEntity sub where sub.id=?1", SubjectEntity.class).setParameter(1, id);
        try {
            System.out.println(query.getSingleResult().getName());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void addSubject(SubjectEntity sub) {
        entityManager.persist(sub);
    }
    public void deleteSubject(SubjectEntity sub) {
        entityManager.remove(sub);
    }

    public List<SubjectEntity> getList() {

        TypedQuery<SubjectEntity> query = entityManager.createNamedQuery("subject.findAll", SubjectEntity.class);
        return query.getResultList();
    }

    public List<SubjectEntity> getActiveList(Boolean active) {
        TypedQuery<SubjectEntity> query = entityManager.createQuery("SELECT subject from SubjectEntity subject where subject.active=?1 ", SubjectEntity.class).setParameter(1, active);
        return query.getResultList();
    }


    public List<SubjectEntity> getFilteredList(Map<String, String> allParams) {

        TypedQuery<SubjectEntity> query = entityManager.createQuery(generateSql(allParams), SubjectEntity.class);
        return query.getResultList();
    }

    public String generateSql(Map<String, String> allParams) {
        StringBuilder query = new StringBuilder(GET_LIST);
        Field[] subjectEntityFields = SubjectEntity.class.getDeclaredFields();
        for (Field field : subjectEntityFields) {
            if (!field.getName().equalsIgnoreCase("id")) {
                String paramFilterValue = allParams.get(field.getName());
                String typeName = field.getType().getSimpleName();
                if (paramFilterValue != null) {
                    String sqlFieldString = getDbFieldString(field);
                    if (sqlFieldString == null) {
                        throw new CustomException("Something went wrong!!!");
                    }
                    if (typeName.equalsIgnoreCase(String.class.getSimpleName())) {
                        query.append(getTextWhereCondition(getDbFieldString(field), paramFilterValue));
                    } else if (typeName.equalsIgnoreCase(Double.class.getSimpleName())
                            || typeName.equalsIgnoreCase(Integer.class.getSimpleName())
                            || typeName.equalsIgnoreCase(Long.class.getSimpleName())) {
                        if (!isNumeric(paramFilterValue)) {
                            throw new CustomException("Field type: " + typeName + " should have a valid value!");
                        }
                        query.append(getNumericWhereCondition(getDbFieldString(field), paramFilterValue));
                    } else if (typeName.equalsIgnoreCase(Boolean.class.getSimpleName())) {
                        if (!paramFilterValue.equalsIgnoreCase("true")
                                && !paramFilterValue.equalsIgnoreCase("false")) {
                            throw new CustomException("Field type: " + typeName + " should have a valid value!");
                        }
                        query.append(getBooleanWhereCondition(getDbFieldString(field), paramFilterValue));
                    } else {
                        throw new CustomException("Field type: " + typeName + " is not configured! Please contact technical support.");
                    }
                }
            }
        }
        String orderValue=allParams.get("order");
        if(orderValue!=null){
            if(!orderValue.equalsIgnoreCase("asc") && !orderValue.equalsIgnoreCase("desc")){
                throw new CustomException("Order value should be asc or desc");
            }
            query.append(" Order by id "+orderValue+" ");
        }
        return query.toString();
    }

    private String getDbFieldString(Field field) {
        for (Annotation annotation : field.getAnnotations()) {
            if (annotation.annotationType().getSimpleName().equalsIgnoreCase("Column")) {
                for (Method method : annotation.annotationType().getDeclaredMethods()) {
                    if (method.getName().equalsIgnoreCase("name")) {
                        try {
                            return method.invoke(annotation, (Object[]) null).toString();
                        } catch (Exception e) {
                            System.out.println("Something is wrong with filter param : " + field.getName() + " so this filter with be ignored");
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private String getTextWhereCondition(String field, String value) {
        return " AND LOWER(" + field + ") LIKE LOWER('%" + value + "%') ";
    }

    private String getNumericWhereCondition(String field, String value) {
        return " AND " + field + " = " + value + " ";
    }

    private String getBooleanWhereCondition(String field, String value) {
        return " AND " + field + " = " + value + " ";
    }
}
