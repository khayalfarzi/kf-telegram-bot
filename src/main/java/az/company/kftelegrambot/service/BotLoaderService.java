package az.company.kftelegrambot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotLoaderService {

    SendMessage load(Update update);
}