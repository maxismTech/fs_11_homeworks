package hw06;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Woman mother = new Woman("Jane", "Karleone", 1952);
        Man father = new Man("Vito", "Karleone", 1951);
        Family family = new Family(mother, father);
        family.setPet(dog);

        String[][] schedule = {
                {"MONDAY", "Coding"},
                {"TUESDAY", "Coding"},
        };

        Man child = new Man("Michael", "Karleone", 1977, 90, schedule);
        family.addChild(child);

        child.greetPet();
        child.describePet();
        dog.respond();
        dog.eat();
        dog.foul();

        System.out.println(child);
        System.out.println(family);
    }
}

