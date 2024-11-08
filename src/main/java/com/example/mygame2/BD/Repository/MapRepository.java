package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map,String> {
}
