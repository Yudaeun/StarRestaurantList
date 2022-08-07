package com.example.demo.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDBAbstract<T extends DbEntity> implements MemoryDB<T>{
    private final List<T> db=new ArrayList<>();
    private int index=0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it->it.getIndex()==index).findFirst();
        //DbEntity에 있는 index를 가져와서(it=제네릭타입에 해당하는 변수)첫번째 꺼를 반환
    }



    @Override
    public T save(T entity) {
        var optionalEntity=db.stream().filter(it->it.getIndex()==entity.getIndex()).findFirst();
        //1. db에 이미 데이터가 있을 때
        if(optionalEntity.isEmpty()){
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }
        //2. db에 데이터가 없을 때
        else{
            var preIndex=optionalEntity.get().getIndex();
            entity.setIndex(preIndex);
            deleteById(preIndex);

            db.add(entity);
            return entity;
        }

    }

    @Override
    public void deleteById(int index) {
        var optinalEntity=db.stream().filter(it->it.getIndex()==index).findFirst();
        if(optinalEntity.isPresent()){
            db.remove(optinalEntity.get());
        }
    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
