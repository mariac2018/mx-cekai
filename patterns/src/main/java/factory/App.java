package factory;

public class App {
    public static void main(String[] args) {
        Animal cat=AnimalFactory.of().createAnimal("Cat");
        cat.eat();
        Animal dog=AnimalFactory.of().createAnimal("Dog");
        dog.eat();
        Animal people=AnimalFactory.of().createAnimal("People");
        people.eat();
    }
}
