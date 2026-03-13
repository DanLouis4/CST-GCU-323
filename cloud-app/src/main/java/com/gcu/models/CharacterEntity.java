package com.gcu.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class CharacterEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Integer characterId;

    @Column(name = "character_name", nullable = false)
    private String characterName;

    @Column(name = "character_level", nullable = false)
    private Integer characterLevel;

    @Column(name = "character_gender", nullable = false)
    private String characterGender;

    @Column(name = "character_description")
    private String characterDescription;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity characterClass; // Renamed to characterClass to avoid conflict with reserved keyword "class"

    public CharacterEntity()
    {
    }

    public Integer getCharacterId()
    {
        return characterId;
    }

    public void setCharacterId(Integer characterId)
    {
        this.characterId = characterId;
    }

    public String getCharacterName()
    {
        return characterName;
    }

    public void setCharacterName(String characterName)
    {
        this.characterName = characterName;
    }

    public Integer getCharacterLevel()
    {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel)
    {
        this.characterLevel = characterLevel;
    }

    public String getCharacterGender()
    {
        return characterGender;
    }

    public void setCharacterGender(String characterGender)
    {
        this.characterGender = characterGender;
    }

    public String getCharacterDescription()
    {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription)
    {
        this.characterDescription = characterDescription;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn)
    {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn()
    {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn)
    {
        this.updatedOn = updatedOn;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public RaceEntity getRace()
    {
        return race;
    }

    public void setRace(RaceEntity race)
    {
        this.race = race;
    }

    public ClassEntity getCharacterClass()
    {
        return characterClass;
    }

    public void setCharacterClass(ClassEntity characterClass)
    {
        this.characterClass = characterClass;
    }
}