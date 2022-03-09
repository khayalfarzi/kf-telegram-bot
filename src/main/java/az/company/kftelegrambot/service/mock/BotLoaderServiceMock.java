package az.company.kftelegrambot.service.mock;

import az.company.kftelegrambot.service.BotLoaderService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotLoaderServiceMock implements BotLoaderService {

    @Override
    public SendMessage load(Update update) {
        return null;
    }
}