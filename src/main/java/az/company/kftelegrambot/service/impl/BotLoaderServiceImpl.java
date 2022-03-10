package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.service.BotLoaderService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotLoaderServiceImpl implements BotLoaderService {

    @Override
    public SendMessage load(Update update) {
        SendMessage sendMessage = new SendMessage();

        String cmd = update.getMessage().getText();

        if (cmd.equals("/health")) {
            sendMessage.setText(update.getMessage().getFrom().getFirstName());

            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        }

        return sendMessage;
    }
}
