package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.I;
import com.example.mygame2.BD.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRepository extends JpaRepository<I, String> {
    Optional<I> findByLogin(String login);
}
