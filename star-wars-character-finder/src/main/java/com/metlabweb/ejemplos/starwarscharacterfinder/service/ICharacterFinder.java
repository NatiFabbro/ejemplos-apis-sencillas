package com.metlabweb.ejemplos.starwarscharacterfinder.service;

import com.metlabweb.ejemplos.starwarscharacterfinder.model.CharacterDTO;

import java.util.List;

public interface ICharacterFinder {

    public List<CharacterDTO> findCharactersByKey(String key);
}
