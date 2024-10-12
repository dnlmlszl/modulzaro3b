package org.example.model;

import org.junit.jupiter.api.Test;

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
}