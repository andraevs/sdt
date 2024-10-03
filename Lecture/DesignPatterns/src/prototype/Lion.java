package prototype;

// Concrete class for Lion
class Lion extends Animal {
    public Lion(int age, String habitat) {
        super("Lion", age, habitat);
    }

    @Override
    public void sound() {
        System.out.println("Roar! I am a " + getSpecies() + ", age: " + getAge() + ", habitat: " + getHabitat());
    }
}