package hw08;

import java.util.Map;

public final class Woman extends Human {
    public Woman() {
        super();
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && !getFamily().getPets().isEmpty()) {
            for (Pet pet : getFamily().getPets()) {
                System.out.printf("Привіт, %s%n", pet.getNickname());
            }
        }
    }

    public void makeup() {
        System.out.println("Я фарбуюсь...");
    }
} 