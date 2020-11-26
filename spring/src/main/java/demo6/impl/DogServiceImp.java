package demo6.impl;

import demo6.AnimalService;
import demo6.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.lang.model.SourceVersion;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DogServiceImp implements DogService {
    @Autowired
    @Qualifier("animal2ServiceImpl")
    AnimalService animalService;

    public DogServiceImp(){
        System.out.println("init dog");
    }

    @Override
    public void dogBark(String voice) {
        System.out.println( "wangwang "+voice);
        animalService.talk();
    }
}
