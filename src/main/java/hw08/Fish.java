package hw08;

import java.util.Set;

public class Fish extends Pet {
    public Fish() {
        super();
        setSpecies(Species.FISH);
    }

    public Fish(String nickname) {
        super(nickname);
        setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println(".....................");
    }
} 