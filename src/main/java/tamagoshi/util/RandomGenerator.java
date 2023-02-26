package tamagoshi.util;

import tamagoshi.tamagoshis.GrosJoueur;
import tamagoshi.tamagoshis.GrosMangeur;
import tamagoshi.tamagoshis.Parieur;
import tamagoshi.tamagoshis.Tamagoshi;

import java.util.Random;

public class RandomGenerator {

    private RandomGenerator(){}
    private static final Random random = new Random();
    private static final char[] VOYELLES = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
    private static final char[] CONSONNES = "bcdfghjklmnpqrstvwxz".toCharArray();

    public static String generateRandomName() {
        StringBuilder name = new StringBuilder();
        int longueurNom = random.nextInt(3, 7);
        boolean voyelle = startWithVowel();

        for (int i = 0; i < longueurNom; i++) {
            if (voyelle) {
                name.append(pickRandomeVowel());
            } else {
                name.append(pickRandomeConsonant());
            }
            voyelle = !voyelle;
        }

        return name.toString();
    }

    private static char pickRandomeVowel() {
        return VOYELLES[random.nextInt(0, VOYELLES.length)];
    }

    private static char pickRandomeConsonant() {
        return CONSONNES[random.nextInt(0, CONSONNES.length)];
    }

    private static boolean startWithVowel() {
        return random.nextBoolean();
    }

    public static Tamagoshi generateRandomTamagoshi() {
        String nom = generateRandomName();
        int type = random.nextInt(1, 101);
        if (type < 33) {
            return new GrosJoueur(nom);
        }
        if (type < 66) {
            return new GrosMangeur(nom);
        }
        return new Parieur(nom);
    }
}
