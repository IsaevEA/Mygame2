package com.example.mygame2.Service;

import com.example.mygame2.BD.Entity.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    boolean add (Player player);
    Player delete (String name);
}
