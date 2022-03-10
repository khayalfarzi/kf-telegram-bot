package az.company.kftelegrambot.model.exception;

import lombok.Getter;

@Getter
public class MqException extends RuntimeException {

    private String code;
    private String description;

    public MqException(String code, String description) {
        super(description);
        this.code = code;
        this.description = description;
    }
}