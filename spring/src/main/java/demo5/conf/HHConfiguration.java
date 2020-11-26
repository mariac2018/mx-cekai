package demo5.conf;

import demo4.MiMIService;
import demo4.MiMiServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "demo5")
public class HHConfiguration {

    @Bean
    LocalDateTime getPlusDate(){
        return LocalDateTime.now().plusDays(1);
    }

    @Bean
    LocalDateTime getPlusDate2(){
        return LocalDateTime.now().minusDays(1);
    }

}
