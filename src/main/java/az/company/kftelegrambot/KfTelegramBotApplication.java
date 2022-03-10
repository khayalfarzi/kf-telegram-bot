package az.company.kftelegrambot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class KfTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfTelegramBotApplication.class, args);
    }

}
