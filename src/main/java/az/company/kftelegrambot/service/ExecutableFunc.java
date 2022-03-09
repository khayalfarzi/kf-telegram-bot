package az.company.kftelegrambot.service;

public interface ExecutableFunc<T> {
    T execute(String... keys);
}