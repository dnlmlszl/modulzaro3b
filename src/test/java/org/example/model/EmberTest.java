package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmberTest {

    private Ember ember;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        ember = new Ember("Test Elek", 32, true);
    }

    @Test
    void testConstructor() {

        assertEquals("Test Elek", ember.getName());
        assertEquals(32, ember.getAge());
        assertTrue(ember.isSpeaksForeignLanguage());
        assertNotNull(ember.getForeignLanguages());
        assertTrue(ember.getForeignLanguages().isEmpty(), "Nyelv lista nem üres az induláskor.");
    }

    @Test
    void testSetName() {
        ember.setName("Új Név");
        assertEquals("Új Név", ember.getName());
    }

    @Test
    void testSetAge() {
        ember.setAge(25);
        assertEquals(25, ember.getAge());
    }

    @Test
    void testSetSpeaksForeignLanguage() {
        ember.setSpeaksForeignLanguage(false);
        assertFalse(ember.isSpeaksForeignLanguage());
    }

    @Test
    void testAddLanguage() {
        ember.addLanguage("Angol");
        ember.addLanguage("Francia");

        List<String> languages = ember.getForeignLanguages();
        assertEquals(2, languages.size());
        assertTrue(languages.contains("Angol"));
        assertTrue(languages.contains("Francia"));
    }

    @Test
    void testSetForeignLanguages() {
        List<String> languages = List.of("Német", "Olasz");
        ember.setForeignLanguages(languages);

        assertEquals(2, ember.getForeignLanguages().size());
        assertEquals(languages, ember.getForeignLanguages());
    }
}