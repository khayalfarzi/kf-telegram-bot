package az.company.kftelegrambot.config;

import az.company.kftelegrambot.bot.BotExecutor;
import az.company.kftelegrambot.queue.MqQueueSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfigurer {

    private final MqQueueSender<Object> sender;

    public BotConfigurer(MqQueueSender<Object> sender) {
        this.sender = sender;
    }

    @Bean
    public TelegramBotsApi telegramBot() throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new BotExecutor(sender));

        return telegramBotsApi;
    }
}