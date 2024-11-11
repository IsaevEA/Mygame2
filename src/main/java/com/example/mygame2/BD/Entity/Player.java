package com.example.mygame2.BD.Entity;

import com.example.mygame2.BD.Dto.PlayerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int score;

    private boolean inPrison;

    private int currentFieldId;


    public Player(PlayerDto playerDto) {
        this.name = playerDto.getName();
        this.score = 1000;
        this.inPrison = false;
        this.currentFieldId = 0;
    }


}
