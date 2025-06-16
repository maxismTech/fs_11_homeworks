package hw08;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.AssertJUnit.*;

public class FamilyTest {

    @Test
    void testToString_Human() {
        Map<String, String> schedule = new HashMap<>();
        schedule.put("MONDAY", "Work");
        Human human = new Human("John", "Doe", "01/01/1980", 90, schedule);
        String expected = "Human{name='John', surname='Doe', birthDate='01/01/1980', iq=90";
        assertTrue(human.toString().contains(expected));
    }

    @Test
    void testToString_Pet() {
        Set<String> habits = new HashSet<>(Arrays.asList("bark", "run"));
        Pet pet = new Dog("Buddy", 3, 50, habits);
        String expected = "DOG{nickname='Buddy";
        assertTrue(pet.toString().contains(expected));
    }

    @Test
    void testAddChild() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Human child = new Man("Lucy", "Smith", "10/10/2000", 95, new HashMap<>());
        family.addChild(child);

        assertEquals(1, family.getChildren().size());
        assertSame(family, child.getFamily());
    }

    @Test
    void testDeleteChildByIndex_Valid() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Human child = new Man("Lucy", "Smith", "10/10/2000", 95, new HashMap<>());
        family.addChild(child);
        boolean result = family.deleteChild(0);

        assertTrue(result);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    void testDeleteChildByIndex_Invalid() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        boolean result = family.deleteChild(0);

        assertFalse(result);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    void testDeleteChildByObject_Exists() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Human child = new Man("Lucy", "Smith", "10/10/2000", 95, new HashMap<>());
        family.addChild(child);

        boolean result = family.deleteChild(new Man("Lucy", "Smith", "10/10/2000", 95, new HashMap<>()));

        assertTrue(result);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    void testDeleteChildByObject_NotExists() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Human child = new Man("Lucy", "Smith", "10/10/2000", 95, new HashMap<>());
        family.addChild(child);

        boolean result = family.deleteChild(new Man("Mark", "Smith", "05/05/2002", 90, new HashMap<>()));

        assertFalse(result);
        assertEquals(1, family.getChildren().size());
    }

    @Test
    void testCountFamily() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        assertEquals(2, family.countFamily());

        family.addChild(new Man("Child1", "Smith", "01/01/2000", 95, new HashMap<>()));
        family.addChild(new Man("Child2", "Smith", "02/02/2002", 90, new HashMap<>()));

        assertEquals(4, family.countFamily());

        Set<String> habits = new HashSet<>(Arrays.asList("bark", "run"));
        Pet dog = new Dog("Buddy", 3, 50, habits);
        family.addPet(dog);

        assertEquals(5, family.countFamily());
    }

    @Test
    void testDogRespond() {
        Set<String> habits = new HashSet<>(Arrays.asList("bark"));
        Pet dog = new Dog("Max", 3, 50, habits);
        dog.respond(); // Перевіряємо, що метод не викидає виняток
    }

    @Test
    void testDogFoul() {
        Set<String> habits = new HashSet<>(Arrays.asList("bark"));
        Pet dog = new Dog("Max", 3, 50, habits);
        assertTrue("Dog should implement Foulable", dog instanceof Foulable);
    }

    @Test
    void testManGreetPet() {
        Set<String> habits = new HashSet<>(Arrays.asList("bark"));
        Pet dog = new Dog("Max", 3, 50, habits);
        Man man = new Man("Bob", "Jones", "15/05/1990", 90, new HashMap<>());
        Family family = new Family(new Woman("Mary", "Jones", "20/03/1990", 85, new HashMap<>()), man);
        family.addPet(dog);
        man.greetPet();
    }

    @Test
    void testWomanGreetPet() {
        Set<String> habits = new HashSet<>(Arrays.asList("swim"));
        Pet fish = new Fish("Nemo", 1, 20, habits);
        Woman woman = new Woman("Alice", "Smith", "10/10/1992", 85, new HashMap<>());
        Family family = new Family(woman, new Man("John", "Smith", "15/05/1990", 90, new HashMap<>()));
        family.addPet(fish);
        woman.greetPet();
    }

    @Test
    void testMultiplePets() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Set<String> dogHabits = new HashSet<>(Arrays.asList("bark", "run"));
        Set<String> catHabits = new HashSet<>(Arrays.asList("meow", "sleep"));
        
        Pet dog = new Dog("Buddy", 3, 50, dogHabits);
        Pet cat = new DomesticCat("Whiskers", 2, 40, catHabits);
        
        family.addPet(dog);
        family.addPet(cat);

        assertEquals(2, family.getPets().size());
        assertTrue(family.getPets().contains(dog));
        assertTrue(family.getPets().contains(cat));
    }

    @Test
    void testDeletePet() {
        Woman mother = new Woman("Anna", "Smith", "15/05/1975", 85, new HashMap<>());
        Man father = new Man("Bob", "Smith", "20/03/1973", 90, new HashMap<>());
        Family family = new Family(mother, father);

        Set<String> habits = new HashSet<>(Arrays.asList("bark", "run"));
        Pet dog = new Dog("Buddy", 3, 50, habits);
        
        family.addPet(dog);
        assertEquals(1, family.getPets().size());
        
        boolean result = family.deletePet(dog);
        assertTrue(result);
        assertEquals(0, family.getPets().size());
    }
} 