package hw07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> habits = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        Dog dog = new Dog("Rock", 5, 75, habits);
        
        Woman mother = new Woman("Jane", "Karleone", 1952);
        Man father = new Man("Vito", "Karleone", 1951);
        Family family = new Family(mother, father);
        family.addPet(dog);

        Map<String, String> schedule = new HashMap<>();
        schedule.put("MONDAY", "Coding");
        schedule.put("TUESDAY", "Coding");

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