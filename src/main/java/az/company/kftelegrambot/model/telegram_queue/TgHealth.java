package az.company.kftelegrambot.model.telegram_queue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TgHealth {

    private String chatId;
    private String text;
}