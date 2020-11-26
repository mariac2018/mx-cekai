package factory;

import javax.lang.model.SourceVersion;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void bark() {
        System.out.println("Dog bark");
    }
}
