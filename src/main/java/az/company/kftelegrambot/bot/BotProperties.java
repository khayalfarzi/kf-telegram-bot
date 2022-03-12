package az.company.kftelegrambot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public abstract class BotProperties extends TelegramLongPollingBot {

    private static final String botUserName = "ProgFather";
    private static final String botToken = "5197396305:AAHiNyfJMqC-FE4K1VsvDfTIiEVaXnJdzGA";

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
    public abstract void onUpdateReceived(Update update);

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
