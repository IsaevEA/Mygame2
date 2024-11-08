package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.Field;
import com.example.mygame2.BD.Entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, String> {
    List<Field> findByMap(Map map);
}
