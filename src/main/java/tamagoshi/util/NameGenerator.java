package tamagoshi.util;

import java.util.Random;

public class NameGenerator {
    private static final Random random = new Random();
    private static final char[] VOYELLES = new char[]{'a','e','i','o','u','y'};
    private static final char[] CONSONNES = "bcdfghjklmnpqrstvwxz".toCharArray();

    public String generateRandomName(){
        StringBuilder name = new StringBuilder();
        int longueurNom = random.nextInt(3, 7);
        boolean voyelle = startWithVowel();

        for (int i = 0; i < longueurNom; i++) {
            if (voyelle){
                name.append(pickRandomeVowel());
            } else {
                name.append(pickRandomeConsonant());
            }
            voyelle = !voyelle;
        }

        return name.toString();
    }

    private char pickRandomeVowel(){
        return VOYELLES[random.nextInt(0, VOYELLES.length)];
    }

    private char pickRandomeConsonant(){
        return CONSONNES[random.nextInt(0, CONSONNES.length)];
    }

    private boolean startWithVowel(){
        return random.nextBoolean();
    }
}
