package factory;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void bark() {
        System.out.println("cat bark");
    }
}
