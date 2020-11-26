package demo6.impl;

import demo6.AnimalService;
import org.springframework.stereotype.Component;

@Component
public class Animal2ServiceImpl implements AnimalService {
    @Override
    public void talk() {
        System.out.println("animal2");
    }
}
