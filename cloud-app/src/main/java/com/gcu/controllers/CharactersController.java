package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gcu.business.CharacterService;
import com.gcu.models.CharacterModel;

@Controller
public class CharactersController
{
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public String characters(Model model)
    {
        model.addAttribute("characters", characterService.getAllCharacters());
        return "characters";
    }

    @GetMapping("/characters/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("character", new CharacterModel());
        return "create-character";
    }

    @PostMapping("/characters/create")
    public String createCharacter(@ModelAttribute("character") CharacterModel character)
    {
        characterService.addCharacter(character);
        return "redirect:/characters";
    }

    @GetMapping("/characters/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model)
    {
        CharacterModel character = characterService.findById(id);

        if (character == null)
        {
            return "redirect:/characters";
        }

        model.addAttribute("character", character);
        return "edit-character";
    }

    @PostMapping("/characters/edit")
    public String updateCharacter(@ModelAttribute("character") CharacterModel character)
    {
        characterService.updateCharacter(character);
        return "redirect:/characters";
    }

    @GetMapping("/characters/delete/{id}")
    public String deleteCharacter(@PathVariable int id)
    {
        characterService.deleteCharacter(id);
        return "redirect:/characters";
    }
}