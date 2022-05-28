package com.metlabweb.ejemplos.starwarscharacterfinder.service;

import com.metlabweb.ejemplos.starwarscharacterfinder.model.CharacterDTO;
import com.metlabweb.ejemplos.starwarscharacterfinder.model.exception.ResourceNotFoundException;
import com.metlabweb.ejemplos.starwarscharacterfinder.repository.ICharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterFinderService implements ICharacterFinder{

    @Autowired
    ICharactersRepository repository;

    @Override
    public List<CharacterDTO> findCharactersByKey(String key) {
        List<CharacterDTO> result=repository.findByKey(key);

        if (result.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron personajes con la key "+ key,100001);
        }else{
            return result;
        }
    }
}
