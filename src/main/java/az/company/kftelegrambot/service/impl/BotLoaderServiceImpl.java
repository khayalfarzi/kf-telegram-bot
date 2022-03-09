package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.service.BotLoaderService;
import az.company.kftelegrambot.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BotLoaderServiceImpl implements BotLoaderService {

    @Autowired
    private CommandService commandService;

    @Override
    public SendMessage load(Update update) {
        SendMessage sendMessage = new SendMessage();

        String cmd = update.getMessage().getText();

        System.out.println(commandService.execute(cmd, update.getMessage().getFrom().getFirstName()));

        if (cmd.equals("/health")) {
            sendMessage.setText(update.getMessage().getFrom().getFirstName());

            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        }

        return sendMessage;
    }
}
