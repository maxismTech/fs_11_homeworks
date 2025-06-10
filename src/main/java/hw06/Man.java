package hw06;

public final class Man extends Human {
    public Man() {
        super();
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPet() != null) {
            System.out.println("Привіт, " + getFamily().getPet().getNickname() + "! Я твій господар!");
        }
    }

    public void repairCar() {
        System.out.println("Я лагоджу машину...");
    }
} 