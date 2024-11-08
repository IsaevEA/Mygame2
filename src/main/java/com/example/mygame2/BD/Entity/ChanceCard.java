package com.example.mygame2.BD.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "chanceCards")
public class ChanceCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String description;
}
