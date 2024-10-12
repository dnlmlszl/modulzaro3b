package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Ember {
    private String name;
    private int age;
    private boolean speaksForeignLanguage;
    private List<String> foreignLanguages;

    public Ember(String name, int age, boolean speaksForeignLanguage) {
        this.name = name;
        this.age = age;
        this.speaksForeignLanguage = speaksForeignLanguage;
        this.foreignLanguages = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpeaksForeignLanguage() {
        return speaksForeignLanguage;
    }

    public void setSpeaksForeignLanguage(boolean speaksForeignLanguage) {
        this.speaksForeignLanguage = speaksForeignLanguage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getForeignLanguages() {
        return foreignLanguages;
    }

    public void setForeignLanguages(List<String> foreignLanguages) {
        this.foreignLanguages = foreignLanguages;
    }

    public void addLanguage(String language) {
        foreignLanguages.add(language);
    }
}
