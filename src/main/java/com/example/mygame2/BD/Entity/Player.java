package com.example.mygame2.BD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int money; // Деньги игрока
    private int position; // Текущая позиция на поле
    private boolean inJail; // Статус игрока (в тюрьме или нет)

    // Конструкторы
    public Player() {
        this.money = 1500; // Стартовая сумма денег
        this.position = 0; // Стартовая позиция (на клетке 0)
        this.inJail = false; // Стартовое состояние (не в тюрьме)
    }

    public Player(String name) {
        this();
        this.name = name;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    // Методы для действий игрока

    // Перемещение игрока по полю
    public void move(int steps) {
        this.position = (this.position + steps) % 40; // Ограничение по числу клеток на поле (40)
    }

    // Уменьшение или увеличение суммы денег
    public void adjustMoney(int amount) {
        this.money += amount;
    }

    // Поместить игрока в тюрьму
    public void goToJail() {
        this.inJail = true;
    }

    // Освободить игрока из тюрьмы
    public void releaseFromJail() {
        this.inJail = false;
    }
}
