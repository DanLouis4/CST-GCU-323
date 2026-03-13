/*package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.models.CharacterModel;

@Repository
public class CharacterRepositoryMemory implements CharacterRepository
{
    private static final List<CharacterModel> characters = new ArrayList<>();
    private static int nextId = 1;

    static
    {
        characters.add(new CharacterModel(nextId++, "Arthas", "Human", "Knight", 5, "Player", "Male"));
        characters.add(new CharacterModel(nextId++, "Lyra", "Elf", "Ranger", 4, "Player", "Female"));
        characters.add(new CharacterModel(nextId++, "Thorgar", "Dwarf", "Warrior", 6, "NPC", "Male"));
        characters.add(new CharacterModel(nextId++, "Mira", "Human", "Wizard", 3, "Player", "Female"));
    }

    @Override
    public List<CharacterModel> findAll()
    {
        return characters;
    }

    @Override
    public CharacterModel findById(int id)
    {
        for (CharacterModel c : characters)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    @Override
    public void add(CharacterModel character)
    {
        character.setId(nextId++);
        characters.add(character);
    }

    @Override
    public void update(CharacterModel updated)
    {
        CharacterModel existing = findById(updated.getId());

        if (existing != null)
        {
            existing.setCharacterName(updated.getCharacterName());
            existing.setCharacterRace(updated.getCharacterRace());
            existing.setCharacterClass(updated.getCharacterClass());
            existing.setCharacterLevel(updated.getCharacterLevel());
            existing.setCharacterType(updated.getCharacterType());
            existing.setCharacterGender(updated.getCharacterGender());
        }
    }

    @Override
    public void delete(int id)
    {
        characters.removeIf(c -> c.getId() == id);
    }
}*/