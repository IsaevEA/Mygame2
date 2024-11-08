package com.example.mygame2.Service.Impl;

import com.example.mygame2.BD.Entity.ChanceCard;
import com.example.mygame2.BD.Entity.Field;
import com.example.mygame2.BD.Entity.Map;
import com.example.mygame2.BD.Repository.ChanceCardRepository;
import com.example.mygame2.BD.Repository.FieldRepository;
import com.example.mygame2.BD.Repository.MapRepository;
import com.example.mygame2.Entity.FieldType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class GameService {
    private final MapRepository mapRepository;
    private final FieldRepository fieldRepository;
    private final ChanceCardRepository chanceCardRepository;

    public GameService(MapRepository mapRepository, FieldRepository fieldRepository, ChanceCardRepository chanceCardRepository) {
        this.mapRepository = mapRepository;
        this.fieldRepository = fieldRepository;
        this.chanceCardRepository = chanceCardRepository;
    }

    public Map createMap(String mapName, List<String> fieldNames) {
        Map map = new Map(mapName);
        mapRepository.save(map);

        for (String fieldName : fieldNames) {
            createFieldForMap(fieldName, map);
        }

        return map;
    }

    private void createFieldForMap(String fieldName, Map map) {
        FieldType fieldType = FieldType.NORMAL;
        Field field = new Field(fieldName, fieldType, "Обычное поле: " + fieldName, map);
        fieldRepository.save(field);
        map.getFields().add(field);
    }


    public ChanceCard drawChanceCard() {
        List<ChanceCard> cards = chanceCardRepository.findAll();
        if (cards.isEmpty()) {
            throw new IllegalStateException("Карточки Шанс не найдены.");
        }
        return getRandomElementFromList(cards);
    }

    private <T> T getRandomElementFromList(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }


    public Field getNextField(Long currentFieldId, Map map) {
        List<Field> fields = fieldRepository.findByMap(map);


        Optional<Field> currentField = fields.stream()
                .filter(field -> field.getId().equals(currentFieldId))
                .findFirst();


        if (currentField.isPresent()) {
            int index = fields.indexOf(currentField.get());
            return index + 1 < fields.size() ? fields.get(index + 1) : fields.get(0);
        }


        return fields.isEmpty() ? null : fields.get(0);
    }
}

