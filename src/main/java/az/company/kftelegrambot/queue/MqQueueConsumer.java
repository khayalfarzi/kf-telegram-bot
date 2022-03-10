package az.company.kftelegrambot.queue;

import az.company.kftelegrambot.model.exception.MqException;
import az.company.kftelegrambot.service.MqListenerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MqQueueConsumer {

    private static final Logger log = LoggerFactory.getLogger(MqQueueConsumer.class);

    private final MqListenerService listenerService;

    public MqQueueConsumer(MqListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @RabbitListener(queues = {"${bot.rabbitmq.queue}"})
    public void receive(@Payload String fileBody) {
        log.info("ActionLog.receive: start.");

        listenerService.send(fileBody);

        log.info("ActionLog.receive: end.");
    }
}