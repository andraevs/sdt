package prototype;

import java.util.HashMap;
import java.util.Map;

// Prototype class for Animal
abstract class Animal implements Cloneable {
    private String species;
    private int age;
    private String habitat;

    public Animal(String species, int age, String habitat) {
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public abstract void sound();

    // Clone method for copying the animal
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Species: " + species + ", Age: " + age + ", Habitat: " + habitat;
    }
}
