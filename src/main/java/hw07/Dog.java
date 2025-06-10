package hw07;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog() {
        super();
        setSpecies(Species.DOG);
    }

    public Dog(String nickname) {
        super(nickname);
        setSpecies(Species.DOG);
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Гав-гав! Я - " + getNickname() + ". Я скучив!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
} 