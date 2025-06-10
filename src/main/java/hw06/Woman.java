package hw06;

public final class Woman extends Human {
    public Woman() {
        super();
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Привіт, " + getFamily().getPet().getNickname() + "! Я твоя господиня!");
        }
    }

    public void makeup() {
        System.out.println("Я фарбуюсь...");
    }
} 