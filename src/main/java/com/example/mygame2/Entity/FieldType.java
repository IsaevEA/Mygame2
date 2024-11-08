package com.example.mygame2.Entity;

public enum FieldType {
    NORMAL("Обычное поле"),
    TAX("Налоговое поле"),
    PRISON("Тюрьма"),
    GO("Старт");

    private final String description;

    FieldType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
