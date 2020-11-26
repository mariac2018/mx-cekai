package factory;

public final class AnimalFactory {
    private AnimalFactory() {

    }

    private static class ClassHolder {
        private static final AnimalFactory INSTANCE = new AnimalFactory();
    }

    public static AnimalFactory of() {
        AnimalFactory instance = ClassHolder.INSTANCE;
        return instance;
    }

    public Animal createAnimal(String str) {
        if (str.equals("Dog")) {
            return new Dog();
        }
        if (str.equals("Cat")) {
            return new Cat();
        }
        throw new IllegalArgumentException("unknow desc");
    }
}
