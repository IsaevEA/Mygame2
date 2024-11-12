package com.example.mygame2.Service.Impl;

import com.example.mygame2.BD.Entity.*;
import com.example.mygame2.BD.Repository.PlayerRepository;
import com.example.mygame2.BD.Repository.FieldRepository;
import com.example.mygame2.BD.Repository.ChanceCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final PlayerRepository playerRepository;
    private final FieldRepository fieldRepository;
    private final ChanceCardRepository chanceCardRepository;

    @Autowired
    public GameService(PlayerRepository playerRepository, FieldRepository fieldRepository, ChanceCardRepository chanceCardRepository) {
        this.playerRepository = playerRepository;
        this.fieldRepository = fieldRepository;
        this.chanceCardRepository = chanceCardRepository;
    }

    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public List<Field> getFieldsOwnedByPlayer(String playerId) {
        return fieldRepository.findByOwnerId(playerId);
    }



    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void addField(Field field) {
        fieldRepository.save(field);
    }

    public void addChanceCard(ChanceCard card) {
        chanceCardRepository.save(card);
    }

    // Пример другого метода для взаимодействия с репозиториями
    public void transferFieldOwnership(String fieldId, String newOwnerId) {
        Optional<Field> fieldOptional = fieldRepository.findById(Integer.parseInt(fieldId));
        if (fieldOptional.isPresent()) {
            Field field = fieldOptional.get();
            Optional<Player> newOwner = playerRepository.findById(newOwnerId);
            newOwner.ifPresent(player -> {
                field.setOwner(player);
                fieldRepository.save(field);
            });
        }
    }
}
