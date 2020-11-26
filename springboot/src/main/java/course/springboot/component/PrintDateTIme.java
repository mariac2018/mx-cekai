package course.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrintDateTIme {
    private static final Logger LOGGER= LoggerFactory.getLogger(PrintDateTIme.class);

    @Scheduled(cron=("*/5 * * * * *"))
    public void foo1(){
        LOGGER.info("scheduled {}", LocalDateTime.now());
    }
}
