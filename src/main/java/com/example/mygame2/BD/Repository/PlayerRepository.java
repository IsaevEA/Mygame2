package com.example.mygame2.BD.Repository;

import com.example.mygame2.BD.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    Player deleteByName(String name);
    Player findByName(String name);
}
