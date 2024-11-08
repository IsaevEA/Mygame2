package com.example.mygame2.Entity;

public enum ChanceCardType {
    MOVE_FORWARD("Переместитесь вперед"),
    PAY_FINE("Заплатите штраф"),
    GET_MONEY("Получите деньги");

    private final String description;

    ChanceCardType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
