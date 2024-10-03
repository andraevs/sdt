package prototype;

// Concrete class for Bear
class Bear extends Animal {
    public Bear(int age, String habitat) {
        super("Bear", age, habitat);
    }

    @Override
    public void sound() {
        System.out.println("Growl! I am a " + getSpecies() + ", age: " + getAge() + ", habitat: " + getHabitat());
    }
}