package hw07;

import java.util.Map;

public final class Man extends Human {
    public Man() {
        super();
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && !getFamily().getPets().isEmpty()) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, " + pet.getNickname() + "! Я твій господар!");
            }
        }
    }

    public void repairCar() {
        System.out.println("Я лагоджу машину...");
    }
} 