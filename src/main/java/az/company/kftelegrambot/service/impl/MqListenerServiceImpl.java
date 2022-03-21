package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.bot.BotExecutor;
import az.company.kftelegrambot.model.ManualHealthChecker;
import az.company.kftelegrambot.model.exception.MqException;
import az.company.kftelegrambot.model.telegram_queue.TgHealth;
import az.company.kftelegrambot.service.MqListenerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MqListenerServiceImpl implements MqListenerService {
    private static final Logger log = LoggerFactory.getLogger(MqListenerServiceImpl.class);

    private final ObjectMapper objectMapper;
    private final BotExecutor botExecutor;

    public MqListenerServiceImpl(ObjectMapper objectMapper, BotExecutor botExecutor) {
        this.objectMapper = objectMapper;
        this.botExecutor = botExecutor;
    }

    @Override
    public void accept(String json) {

        Object item;
        try {
            item = objectMapper.readValue(json, Object.class);

            if (item instanceof TgHealth) {
                item = objectMapper.readValue(json, TgHealth.class);

                SendMessage sendMessage = new SendMessage();

                sendMessage.setText(((TgHealth) item).getText());
                sendMessage.setChatId(String.valueOf(((TgHealth) item).getChatId()));

                botExecutor.execute(sendMessage);

            } else if (item instanceof ManualHealthChecker)
                item = objectMapper.readValue(json, ManualHealthChecker.class);

            log.info("ActionLog.accept: item {}", item);
        } catch (JsonProcessingException e) {
            log.error("ActionLog.accept: error.");
            log.error("ActionLog.accept: ", e);
            throw new MqException("MQ_UNEXPECTED_EXCEPTION", e.getMessage());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}