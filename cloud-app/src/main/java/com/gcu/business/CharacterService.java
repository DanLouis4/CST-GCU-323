package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.CharacterRepository;
import com.gcu.models.CharacterModel;

@Service
public class CharacterService
{
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterModel> getAllCharacters()
    {
        return characterRepository.findAll();
    }

    public CharacterModel findById(int id)
    {
        return characterRepository.findById(id);
    }

    public void addCharacter(CharacterModel character)
    {
        characterRepository.add(character);
    }

    public void updateCharacter(CharacterModel character)
    {
        characterRepository.update(character);
    }

    public void deleteCharacter(int id)
    {
        characterRepository.delete(id);
    }
}