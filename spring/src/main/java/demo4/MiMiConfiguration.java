package demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiMiConfiguration {
    @Bean
    public MiMIService mimiService(){
        return new MiMiServiceImp();
    }
}
