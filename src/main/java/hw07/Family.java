package hw07;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
        mother.setFamily(this);
        father.setFamily(this);
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }
        Human child = children.remove(index);
        child.setFamily(null);
        return true;
    }

    public boolean deleteChild(Human child) {
        boolean removed = children.remove(child);
        if (removed) {
            child.setFamily(null);
        }
        return removed;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public boolean deletePet(Pet pet) {
        return pets.remove(pet);
    }

    public int countFamily() {
        return 2 + children.size() + pets.size();
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pets=%s}",
                mother.getName() + " " + mother.getSurname(),
                father.getName() + " " + father.getSurname(),
                children, pets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family family)) return false;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) {
            mother.setFamily(this);
        }
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if (father != null) {
            father.setFamily(this);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
        for (Human child : children) {
            child.setFamily(this);
        }
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
} 