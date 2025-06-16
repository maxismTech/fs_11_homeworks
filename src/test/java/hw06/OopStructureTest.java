package hw06;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class OopStructureTest {

    @Test
    public void testDogRespond() {
        Pet dog = new Dog("Max", 3, 50, new String[]{"bark"});
        dog.respond(); // Перевіряємо, що метод не викидає виняток
    }

    @Test
    public void testFishNoFoul() {
        Pet fish = new Fish("Nemo", 1, 20, new String[]{"swim"});
        assertFalse("Fish should not implement Foulable", fish instanceof Foulable);
    }

    @Test
    public void testDogFoul() {
        Pet dog = new Dog("Max", 3, 50, new String[]{"bark"});
        assertTrue("Dog should implement Foulable", dog instanceof Foulable);
    }

    @Test
    public void testManGreetPet() {
        Pet dog = new Dog("Max", 3, 50, new String[]{"bark"});
        Man man = new Man("Bob", "Jones", 1990);
        Family family = new Family(new Woman("Mary", "Jones", 1990), man);
        family.setPet(dog);
        man.greetPet(); // Перевіряємо, що метод не викидає виняток
    }

    @Test
    public void testWomanGreetPet() {
        Pet fish = new Fish("Nemo", 1, 20, new String[]{"swim"});
        Woman woman = new Woman("Alice", "Smith", 1992);
        Family family = new Family(woman, new Man("John", "Smith", 1990));
        family.setPet(fish);
        woman.greetPet(); // Перевіряємо, що метод не викидає виняток
    }
}
