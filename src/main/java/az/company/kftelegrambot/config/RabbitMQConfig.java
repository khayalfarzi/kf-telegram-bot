package az.company.kftelegrambot.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String host = "localhost";
    private static final String username = "guest";
    private static final String password = "guest";

    @Value("${bot.rabbitmq.queue}")
    private String queueName;

    @Value("${bot.rabbitmq.exchange}")
    private String queueExchange;

    @Value("${bot.rabbitmq.routing-key}")
    private String queueRoutingKey;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public Queue mqQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding demoBinding(Queue mqQueue, DirectExchange exchange) {
        return BindingBuilder.bind(mqQueue).to(exchange).with(queueRoutingKey);
    }
}