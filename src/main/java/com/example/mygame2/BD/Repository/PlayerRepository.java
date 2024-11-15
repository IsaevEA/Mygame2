package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    Optional<Player> findByName(String name);

}
