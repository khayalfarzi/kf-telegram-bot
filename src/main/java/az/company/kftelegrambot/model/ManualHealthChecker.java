package az.company.kftelegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManualHealthChecker {

    private Long id;
    private LocalDateTime checkingAt;
}