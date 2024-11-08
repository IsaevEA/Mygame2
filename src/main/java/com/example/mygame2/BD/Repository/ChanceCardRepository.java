package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.ChanceCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChanceCardRepository extends JpaRepository<ChanceCard, String> {
}
