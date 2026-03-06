package com.gcu.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CharacterModel
{
	private int id;
	
    @NotBlank(message = "Character name is required.")
    private String characterName;

    @NotBlank(message = "Character race is required.")
    private String characterRace;

    @NotBlank(message = "Character class is required.")
    private String characterClass;

    @NotNull(message = "Character level is required.")
    @Min(value = 1, message = "Character level must be at least 1.")
    private Integer characterLevel;

    @NotBlank(message = "Character type is required.")
    private String characterType;

    @NotBlank(message = "Character gender is required.")
    private String characterGender;

    public CharacterModel()
    {
    }

    public CharacterModel(int id, String characterName, String characterRace, String characterClass,
                          Integer characterLevel, String characterType, String characterGender)
    {
    	this.id = id;
        this.characterName = characterName;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.characterLevel = characterLevel;
        this.characterType = characterType;
        this.characterGender = characterGender;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCharacterName() { return characterName; }
    public void setCharacterName(String characterName) { this.characterName = characterName; }

    public String getCharacterRace() { return characterRace; }
    public void setCharacterRace(String characterRace) { this.characterRace = characterRace; }

    public String getCharacterClass() { return characterClass; }
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public Integer getCharacterLevel() { return characterLevel; }
    public void setCharacterLevel(Integer characterLevel) { this.characterLevel = characterLevel; }

    public String getCharacterType() { return characterType; }
    public void setCharacterType(String characterType) { this.characterType = characterType; }

    public String getCharacterGender() { return characterGender; }
    public void setCharacterGender(String characterGender) { this.characterGender = characterGender; }
}