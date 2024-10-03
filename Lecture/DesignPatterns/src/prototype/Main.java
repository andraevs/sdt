package prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create the animal registry and load prototypes
        AnimalRegistry animalRegistry = new AnimalRegistry();
        animalRegistry.loadCache();

        // Retrieve and clone a Lion from the registry
        Animal clonedLion = animalRegistry.getAnimal("Lion");
        clonedLion.setAge(6); // Modify the cloned lion's age
        clonedLion.setHabitat("Zoo");
        System.out.println(clonedLion);
        clonedLion.sound();

        // Retrieve and clone a Bear from the registry
        Animal clonedBear = animalRegistry.getAnimal("Bear");
        clonedBear.setHabitat("Arctic");
        System.out.println(clonedBear);
        clonedBear.sound();

        // Clone another lion with different properties
        Animal anotherClonedLion = animalRegistry.getAnimal("Lion");
        anotherClonedLion.setAge(8);  // Modify the second lion
        System.out.println(anotherClonedLion);
        anotherClonedLion.sound();
    }
}
