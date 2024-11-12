package com.example.monopoly.model;

import com.example.mygame2.BD.Entity.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type; // Например, "Property", "Chance", "Tax", "Jail"
    private Integer price;
    private Integer rent;

    // Конструкторы
    public Cell() {}

    public Cell(String name, String type, Integer price, Integer rent) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    // Метод для обработки действий на ячейке
    public void action(Player player) {
        // Логика обработки действий для каждого типа ячейки
        // Например, если это "Property", то игрок может купить эту ячейку.
    }
}
