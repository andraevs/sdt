package prototype;

import java.util.HashMap;
import java.util.Map;

// Prototype Registry for storing and retrieving animal prototypes
class AnimalRegistry {
    private Map<String, Animal> animalMap = new HashMap<>();

    // Pre-load some animal prototypes into the registry
    public void loadCache() {
        Lion lion = new Lion(5, "Savannah");
        Bear bear = new Bear(7, "Forest");

        animalMap.put("Lion", lion);
        animalMap.put("Bear", bear);
    }

    // Get the cloned animal by species name
    public Animal getAnimal(String species) throws CloneNotSupportedException {
        Animal cachedAnimal = animalMap.get(species);
        return (Animal) cachedAnimal.clone();
    }
}
