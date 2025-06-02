package hw05;


public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Human mother = new Human("Jane", "Karleone", 1952);
        Human father = new Human("Vito", "Karleone", 1951);
        Family family = new Family(mother, father);
        family.setPet(dog);

        String[][] schedule = {
                {DayOfWeek.MONDAY.name(), "Coding"},
                {DayOfWeek.TUESDAY.name(), "Coding"},
        };

        Human child = new Human("Michael", "Karleone", 1977, 90, schedule);
        family.addChild(child);

        child.greetPet();
        child.describePet();
        dog.respond();
        dog.eat();
        dog.foul();

        System.out.println(child);
        System.out.println(family);


        for (int i = 0; i < 1_000_000; i++) {
            Human temp1 = new Human("Name" + i, "Surname", 2002);
        }

        System.gc();
    }
}
