package com.metlabweb.ejemplos.starwarscharacterfinder.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metlabweb.ejemplos.starwarscharacterfinder.model.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharactersRepository implements ICharactersRepository {

    List<CharacterDTO> characters;

    public CharactersRepository() {
        this.characters = loadFromDB();
    }

    private List<CharacterDTO> loadFromDB() {
        List<CharacterDTO> ret = null;

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};

        try {
            ret = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public List<CharacterDTO> findByKey(String name) {
        return this.characters.stream()
                .filter(character -> character.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }
}
