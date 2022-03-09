package az.company.kftelegrambot;

import az.company.kftelegrambot.service.BotLoaderService;
import az.company.kftelegrambot.service.mock.BotLoaderServiceMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KfTelegramBotApplicationTests {

    BotLoaderService service = new BotLoaderServiceMock();

    @Test
    void contextLoads() {
//        service.load();
    }

}
