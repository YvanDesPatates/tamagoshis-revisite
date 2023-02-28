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

    /**
     * @return a String build with half random consonant and half random vowel. The string returned start randomly with a consonant or a vowel
     */
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

    /**
     * @return a random vowel
     */
    private static char pickRandomeVowel() {
        return VOYELLES[random.nextInt(0, VOYELLES.length)];
    }

    /**
     * @return a random consonant
     */
    private static char pickRandomeConsonant() {
        return CONSONNES[random.nextInt(0, CONSONNES.length)];
    }

    /**
     * @return true in 50% cases
     */
    private static boolean startWithVowel() {
        return random.nextBoolean();
    }

    /**
     * @return a tamagoshi that randomly be a GrosJoueur, a GrosMangeur or a Parieur, with a name randomly choosen by generateRandomName()
     */
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
