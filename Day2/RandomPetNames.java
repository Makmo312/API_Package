package API.HomeWork.Day2;

import java.util.Random;

public class RandomPetNames {

    public static String getPetNames() {

        Random random = new Random();

        int upperBound = 26;
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String petName = alphabet[random.nextInt(upperBound)].toUpperCase();

        for (int i = 0; i < 5; i++) {

            petName += alphabet[random.nextInt(upperBound)];
        }
        System.out.println(petName);
        return petName;
    }
}
