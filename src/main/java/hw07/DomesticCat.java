package hw07;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    public DomesticCat() {
        super();
        setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println("Мяу! Я - " + getNickname() + ". Я скучив!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
} 