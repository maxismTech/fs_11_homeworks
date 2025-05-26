package hw04;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];

        mother.setFamily(this);
        father.setFamily(this);
    }

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        child.setFamily(this);
        children = newChildren;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) newChildren[j++] = children[i];
        }
        children = newChildren;
        return true;
    }

    public int countFamily() {
        return 2 + children.length;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}",
                mother.getName() + " " + mother.getSurname(),
                father.getName() + " " + father.getSurname(),
                Arrays.toString(children),
                pet);
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
        for (Human child : children) {
            child.setFamily(this);
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

}

