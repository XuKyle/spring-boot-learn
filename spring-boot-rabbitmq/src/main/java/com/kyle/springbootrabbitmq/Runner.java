package com.kyle.springbootrabbitmq;

import com.kyle.springbootrabbitmq.message.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Sending message...");
        rabbitTemplate.convertAndSend(SpringBootRabbitmqApplication.queueName, "Hello from RabbitMQ!");
        receiver.getLatch().await(100, TimeUnit.SECONDS);
        context.close();
    }
}
