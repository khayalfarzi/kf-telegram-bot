package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.model.ManualHealthChecker;
import az.company.kftelegrambot.queue.MqQueueSender;
import az.company.kftelegrambot.service.BotLoaderService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BotLoaderServiceImpl implements BotLoaderService {

    private final MqQueueSender<ManualHealthChecker> mqQueueSender;

    public BotLoaderServiceImpl(MqQueueSender<ManualHealthChecker> mqQueueSender) {
        this.mqQueueSender = mqQueueSender;
    }

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
