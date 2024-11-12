package com.example.mygame2.BD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {

    List<Field> findByOwnerId(String ownerId);

    Field findByName(String name);

}
