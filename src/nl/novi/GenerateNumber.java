package nl.novi;

import java.util.Random;

public class GenerateNumber {
    //velden/attributen
    private int randomNumber;
    private int maximum = 2;

    //constructor
    public GenerateNumber(){
        Random randomizer = new Random();
        randomNumber = randomizer.nextInt(maximum) + 1;
        this.randomNumber = randomNumber;
    }

    //getters and setters
    public int getRandomNumber(){
        return randomNumber;
    }
}
