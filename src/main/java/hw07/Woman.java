package hw07;

import java.util.Map;

public final class Woman extends Human {
    public Woman() {
        super();
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && !getFamily().getPets().isEmpty()) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, " + pet.getNickname() + "! Я твоя господиня!");
            }
        }
    }

    public void makeup() {
        System.out.println("Я фарбуюсь...");
    }
} 