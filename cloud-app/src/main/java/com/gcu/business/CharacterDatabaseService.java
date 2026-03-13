package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gcu.data.CharacterRepository;
import com.gcu.data.ClassRepository;
import com.gcu.data.RaceRepository;
import com.gcu.data.UserRepository;
import com.gcu.models.CharacterEntity;
import com.gcu.models.CharacterModel;
import com.gcu.models.ClassEntity;
import com.gcu.models.RaceEntity;
import com.gcu.models.UserEntity;

@Service
public class CharacterDatabaseService
{
    private final CharacterRepository characterRepository;
    private final UserRepository userRepository;
    private final RaceRepository raceRepository;
    private final ClassRepository classRepository;

    public CharacterDatabaseService(
            CharacterRepository characterRepository,
            UserRepository userRepository,
            RaceRepository raceRepository,
            ClassRepository classRepository)
    {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.raceRepository = raceRepository;
        this.classRepository = classRepository;
    }

    public List<CharacterModel> getAllCharacters()
    {
        List<CharacterModel> models = new ArrayList<>();
        List<CharacterEntity> entities = characterRepository.findAll();

        for (CharacterEntity entity : entities)
        {
            models.add(toModel(entity));
        }

        return models;
    }

    public CharacterModel findById(int id)
    {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        return entity.map(this::toModel).orElse(null);
    }

    public void addCharacter(CharacterModel model)
    {
        CharacterEntity entity = new CharacterEntity();

        entity.setCharacterName(model.getCharacterName());
        entity.setCharacterLevel(model.getCharacterLevel());
        entity.setCharacterGender(model.getCharacterGender());
        entity.setCharacterDescription(model.getCharacterType()); // temporary placeholder

        UserEntity user = userRepository.findById(1).orElse(null);
        RaceEntity race = raceRepository.findByRaceName(model.getCharacterRace());
        ClassEntity clazz = classRepository.findByClassName(model.getCharacterClass());

        entity.setUser(user);
        entity.setRace(race);
        entity.setCharacterClass(clazz);

        characterRepository.save(entity);
    }

    public void updateCharacter(CharacterModel model)
    {
        Optional<CharacterEntity> optionalEntity = characterRepository.findById(model.getId());

        if (optionalEntity.isPresent())
        {
            CharacterEntity entity = optionalEntity.get();

            entity.setCharacterName(model.getCharacterName());
            entity.setCharacterLevel(model.getCharacterLevel());
            entity.setCharacterGender(model.getCharacterGender());
            entity.setCharacterDescription(model.getCharacterType()); // temporary placeholder

            RaceEntity race = raceRepository.findByRaceName(model.getCharacterRace());
            ClassEntity clazz = classRepository.findByClassName(model.getCharacterClass());

            entity.setRace(race);
            entity.setCharacterClass(clazz);

            characterRepository.save(entity);
        }
    }

    public void deleteCharacter(int id)
    {
        characterRepository.deleteById(id);
    }

    private CharacterModel toModel(CharacterEntity entity)
    {
        CharacterModel model = new CharacterModel();

        model.setId(entity.getCharacterId());
        model.setCharacterName(entity.getCharacterName());
        model.setCharacterRace(entity.getRace() != null ? entity.getRace().getRaceName() : "");
        model.setCharacterClass(entity.getCharacterClass() != null ? entity.getCharacterClass().getClassName() : "");
        model.setCharacterLevel(entity.getCharacterLevel());
        model.setCharacterGender(entity.getCharacterGender());

        // temporary mapping until I refactor the form properly
        model.setCharacterType(entity.getCharacterDescription() != null ? entity.getCharacterDescription() : "");

        return model;
    }
}