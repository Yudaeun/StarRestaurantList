package com.example.demo.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDB<T> {
    Optional<T> findById(int index); //T에 해당하는 엔티티를 찾아서 리턴하는 메서드
    T save(T entity);
    void deleteById(int index);
    List<T> listAll();
}
