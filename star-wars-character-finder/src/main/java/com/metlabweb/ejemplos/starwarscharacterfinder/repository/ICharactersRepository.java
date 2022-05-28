package com.metlabweb.ejemplos.starwarscharacterfinder.repository;


import com.metlabweb.ejemplos.starwarscharacterfinder.model.CharacterDTO;

import java.util.List;

public interface ICharactersRepository {
    List<CharacterDTO> findByKey(String name);
}
