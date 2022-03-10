package az.company.kftelegrambot.service;

import az.company.kftelegrambot.model.Demo;
import az.company.kftelegrambot.queue.MqQueueSender;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final MqQueueSender<Demo> mqQueueSender;

    public TestService(MqQueueSender<Demo> mqQueueSender) {
        this.mqQueueSender = mqQueueSender;
    }

    public void test() {
        Demo demo = new Demo(1L, "Blaaaaaa");
        mqQueueSender.sendMessageToQueue(demo);
    }
}