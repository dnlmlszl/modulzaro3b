package org.example.ui;

import org.example.model.Ember;

import java.util.Scanner;

public class Program {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        String name = getStringInput("Add meg a neved: ");
        int age = getValidatedIntegerInput("Add meg a korodat: ");

        System.out.println("Beszélsz idegen nyelvet? (true - igen / false - nem): ");
        boolean speaksForeignLanguages = getBooleanInput();

        Ember ember = new Ember(name, age, speaksForeignLanguages);

        if (speaksForeignLanguages) {
            addLanguages(ember);
        }

        introduction(ember);

        System.out.print("Szeretnél új nyelvet tanulni? (true - igen / false - nem): ");
        boolean learnNewLanguage = getBooleanInput();

        if (learnNewLanguage) {
            learnNewLanguages(ember);
        }

        System.out.println("Frissített bemutatkozás:");
        introduction(ember);
    }

    private void learnNewLanguages(Ember ember) {
        String newLang = getStringInput("Add meg a megtanult új nyelv nevét: ");
        ember.addLanguage(newLang);
        System.out.println(ember.getName() + " új nyelvet tanult meg: " + newLang);
    }

    private void introduction(Ember ember) {
        System.out.println("Név: " + ember.getName());
        System.out.println("Kor: " + ember.getAge());

        if (ember.isSpeaksForeignLanguage()) {
            System.out.println("Az alábbi idegen nyelveken beszélek: ");

            if (ember.getForeignLanguages().isEmpty()) {
                System.out.println("Nincsenek megadott idegen nyelvek.");
            } else {
                for (String language : ember.getForeignLanguages()) {
                    System.out.println("- " + language);
                }
            }
        } else {
            System.out.println("Nem beszélek idegen nyelvet.");
        }
    }

    private void addLanguages(Ember ember) {
        int numOfLanguages = getValidatedIntegerInput("Add meg hány idegen nyelvet beszélsz: ");

        for (int i = 0; i < numOfLanguages; i++) {
            String language = getStringInput("Add meg az idegen nyelv nevét: ");
            ember.addLanguage(language);
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private boolean getBooleanInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("igen")) {
                return true;
            } else if (input.equals("false") || input.equals("nem")) {
                return false;
            } else {
                System.out.println("Érvénytelen válasz. Kérlek add meg, hogy igaz (true/igen) vagy hamis (false/nem): ");
            }
        }
    }

    private int getValidatedIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Kérlek adj meg egy nem negatív számot.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Érvénytelen bemenet. Kérlek egész számot adj meg.");
            }
        }
    }
}
