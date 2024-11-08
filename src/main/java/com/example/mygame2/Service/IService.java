package com.example.mygame2.Service;

import com.example.mygame2.BD.Entity.I;
import com.example.mygame2.BD.Entity.Player;
import org.springframework.stereotype.Service;

@Service
public interface IService {
    void save (I i);
    Player findByLogin (String login);
}
