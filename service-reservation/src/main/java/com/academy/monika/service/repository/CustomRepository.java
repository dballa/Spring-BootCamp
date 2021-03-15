package com.academy.monika.service.repository;

import com.academy.monika.service.model.User;

import java.util.List;

public interface CustomRepository<T extends Object> {
    T get(String uuid);
    List<T> getList();
    T create(T obj);
    T update( String uuid, T updatedObj);
    T delete(String uuid);
}
