package az.company.kftelegrambot.config;

import az.company.kftelegrambot.service.BotLoaderService;
import az.company.kftelegrambot.service.impl.BotLoaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class BotProperties extends TelegramLongPollingBot {

    private final String botUserName;
    private final String botToken;

    private final BotLoaderService botLoaderService = new BotLoaderServiceImpl();

    public BotProperties(@Autowired(required = false) String botUserName,
                         @Autowired(required = false) String botToken) {
        this.botUserName = botUserName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = botLoaderService.load(update);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
