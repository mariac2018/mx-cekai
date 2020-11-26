package demo6.impl;

import demo6.AnimalService;
import org.springframework.stereotype.Component;

@Component
public class AnimalServiceImp implements AnimalService {
    @Override
    public void talk() {
        System.out.println("hello...");
    }
}
