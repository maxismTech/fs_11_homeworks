package hw04;

public class Main {
    public static void main(String[] args) {
        Pet dog = new Pet("dog", "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Human mother = new Human("Jane", "Karleone", 1952);
        Human father = new Human("Vito", "Karleone", 1951);
        Family family = new Family(mother, father);
        family.setPet(dog);

        Human child = new Human("Michael", "Karleone", 1977, 90,
                new String[][]{{"Monday", "Football"}, {"Tuesday", "Video Games"}});
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

