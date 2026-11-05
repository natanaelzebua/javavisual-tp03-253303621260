package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {
            System.out.println("❌ Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        
        characterList.add(character);
        System.out.println("✅ Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target != null) {
            characterList.remove(target);
            return true;
        }
        return false;
    }

    public ArrayList<Character> getAllCharacters() {
        return characterList;
    }
}