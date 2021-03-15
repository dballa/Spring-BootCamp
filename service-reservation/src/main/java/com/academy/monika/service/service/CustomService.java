package com.academy.monika.service.service;

import java.util.List;

public interface CustomService<T extends Object> {
    T get(String uuid);
    List<T> getList();
    T add(T obj);
    T update( String uuid, T updatedObj);
    T delete(String uuid);
}
