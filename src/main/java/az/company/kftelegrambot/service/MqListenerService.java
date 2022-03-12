package az.company.kftelegrambot.service;

public interface MqListenerService {

    void accept(String json);
}