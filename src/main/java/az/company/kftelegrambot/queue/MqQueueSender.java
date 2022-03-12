package az.company.kftelegrambot.queue;

import az.company.kftelegrambot.model.exception.MqException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqQueueSender<T> {
    private static final Logger log = LoggerFactory.getLogger(MqQueueSender.class);

    @Value("${bot.rabbitmq.routing-key}")
    private String queueRoutingKey;

    @Value("${bot.rabbitmq.exchange}")
    private String queueExchange;

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public MqQueueSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessageToQueue(T item) {
        log.info("ActionLog.sendMessageToQueue: start.");

        try {
            String json = objectMapper.writeValueAsString(item);
            rabbitTemplate.convertAndSend(queueExchange, queueRoutingKey, json);

        } catch (JsonProcessingException e) {
            log.error("ActionLog.sendMessageToQueue: error.", e);
            throw new MqException("MQ_UNEXPECTED_EXCEPTION", e.getMessage());
        }

        log.info("ActionLog.sendMessageToQueue: end.");
    }
}