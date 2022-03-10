package az.company.kftelegrambot.service.func;

public interface ExecutableFunc<T> {
    T execute(String... keys);
}