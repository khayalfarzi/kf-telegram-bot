package az.company.kftelegrambot.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("redis_conf")
public class RedisConfModel {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}