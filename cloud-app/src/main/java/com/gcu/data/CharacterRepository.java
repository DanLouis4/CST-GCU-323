package com.gcu.data;

import java.util.List;

import com.gcu.models.CharacterModel;

public interface CharacterRepository
{
    List<CharacterModel> findAll();

    CharacterModel findById(int id);

    void add(CharacterModel character);

    void update(CharacterModel character);

    void delete(int id);
}