package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.model.Demo;
import az.company.kftelegrambot.model.exception.MqException;
import az.company.kftelegrambot.queue.MqQueueConsumer;
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
    public void send(String json) {
        try {
            System.out.println("Message " + json);

            Demo item = objectMapper.readValue(json, Demo.class);

            log.debug("ActionLog.send: item {}", item);

        } catch (JsonProcessingException e) {
            log.error("ActionLog.send: error.");
            log.error("ActionLog.send: ", e);
            throw new MqException("MQ_UNEXPECTED_EXCEPTION", e.getMessage());
        }
    }
}