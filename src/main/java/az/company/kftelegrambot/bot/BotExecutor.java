package az.company.kftelegrambot.bot;

import az.company.kftelegrambot.model.telegram_queue.TgHealth;
import az.company.kftelegrambot.queue.MqQueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class BotExecutor extends BotProperties {

    @Autowired
    private MqQueueSender<TgHealth> sender;

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();

        String cmd = update.getMessage().getText();

        if (cmd.equals("/health")) {
            String text = "Welcome: " + update.getMessage().getFrom().getFirstName()
                    + " " + update.getMessage().getFrom().getLastName();

            TgHealth tgHealth = TgHealth.builder()
                    .chatId(String.valueOf(update.getMessage().getChatId()))
                    .text(text)
                    .build();

            sender.sendMessageToQueue(tgHealth);

//            sendMessage.setText(update.getMessage().getFrom().getFirstName());
//
//            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        }

//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
