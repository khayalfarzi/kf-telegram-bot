package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.model.ManualHealthChecker;
import az.company.kftelegrambot.model.exception.MqException;
import az.company.kftelegrambot.model.telegram_queue.TgHealth;
import az.company.kftelegrambot.service.MqListenerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MqListenerServiceImpl implements MqListenerService {
    private static final Logger log = LoggerFactory.getLogger(MqListenerServiceImpl.class);

    private final ObjectMapper objectMapper;

    public MqListenerServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void accept(String json) {

        try {
            TgHealth item = objectMapper.readValue(json, TgHealth.class);

//            ManualHealthChecker item = objectMapper.readValue(json, ManualHealthChecker.class);

            log.info("ActionLog.accept: item {}", item);
        } catch (JsonProcessingException e) {
            log.error("ActionLog.accept: error.");
            log.error("ActionLog.accept: ", e);
            throw new MqException("MQ_UNEXPECTED_EXCEPTION", e.getMessage());
        }
    }
}