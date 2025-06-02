package hw05;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

public class MyFamilyTest {

    @Test
    void testToString_Human() {
        Human human = new Human("John", "Doe", 1980, 90, new String[][]{{"MONDAY", "Work"}});
        String expected = "Human{name='John', surname='Doe', year=1980, iq=90";
        assertTrue(human.toString().contains(expected));
    }

    @Test
    void testToString_Pet() {
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 50, new String[]{"bark", "run"});
        String expected = "DOG{nickname='Buddy";
        assertTrue(pet.toString().contains(expected));
    }

    @Test
    void testAddChild() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        Human child = new Human("Lucy", "Smith", 2000);
        family.addChild(child);

        assertEquals(1, family.getChildren().length);
        assertSame(family, child.getFamily());
    }

    @Test
    void testDeleteChildByIndex_Valid() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        Human child = new Human("Lucy", "Smith", 2000);
        family.addChild(child);
        boolean result = family.deleteChild(0);

        assertTrue(result);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    void testDeleteChildByIndex_Invalid() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        boolean result = family.deleteChild(0);

        assertFalse(result);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    void testDeleteChildByObject_Exists() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        Human child = new Human("Lucy", "Smith", 2000);
        family.addChild(child);

        boolean result = family.deleteChild(new Human("Lucy", "Smith", 2000));

        assertTrue(result);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    void testDeleteChildByObject_NotExists() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        Human child = new Human("Lucy", "Smith", 2000);
        family.addChild(child);

        boolean result = family.deleteChild(new Human("Mark", "Smith", 2002));

        assertFalse(result);
        assertEquals(1, family.getChildren().length);
    }

    @Test
    void testCountFamily() {
        Human mother = new Human("Anna", "Smith", 1975);
        Human father = new Human("Bob", "Smith", 1973);
        Family family = new Family(mother, father);

        assertEquals(2, family.countFamily());

        family.addChild(new Human("Child1", "Smith", 2000));
        family.addChild(new Human("Child2", "Smith", 2002));

        assertEquals(4, family.countFamily());
    }
}

