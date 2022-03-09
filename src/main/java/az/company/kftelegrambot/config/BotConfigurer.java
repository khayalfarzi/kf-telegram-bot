package az.company.kftelegrambot.config;

import az.company.kftelegrambot.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfigurer {

    @Value("${bot.telegram.api.user-name}")
    private String botUserName;

    @Value("${bot.telegram.api.token}")
    private String botToken;

    @Autowired
    private CommandService commandService;

    @Bean
    public TelegramBotsApi telegramBot() throws TelegramApiException {

        commandService.addFunc("/health", keys -> keys[0]);

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new BotProperties(botUserName, botToken));

        return telegramBotsApi;
    }
}