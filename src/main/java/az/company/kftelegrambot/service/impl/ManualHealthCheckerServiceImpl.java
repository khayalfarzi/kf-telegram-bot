package az.company.kftelegrambot.service.impl;

import az.company.kftelegrambot.model.ManualHealthChecker;
import az.company.kftelegrambot.queue.MqQueueSender;
import az.company.kftelegrambot.service.ManualHealthCheckerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManualHealthCheckerServiceImpl implements ManualHealthCheckerService {

    private final MqQueueSender<ManualHealthChecker> mqQueueSender;

    public ManualHealthCheckerServiceImpl(MqQueueSender<ManualHealthChecker> mqQueueSender) {
        this.mqQueueSender = mqQueueSender;
    }

    @Override
    public void check() {
        ManualHealthChecker manualHealthChecker = new ManualHealthChecker(1L, LocalDateTime.now());
        mqQueueSender.sendMessageToQueue(manualHealthChecker);
    }
}