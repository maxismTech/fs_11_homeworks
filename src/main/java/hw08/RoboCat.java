package hw08;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat() {
        super();
        setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Бі-біп! Я - " + getNickname() + ". Я скучив!");
    }
} 