package com.github.rod1andrade.lendbookbackend.queues;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueueSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(Map<String, Object> map, String queueName) {
        log.info("Queue sender: {}", map);
        Queue queue = new Queue(queueName, true);
        rabbitTemplate.convertAndSend(queue.getName(), map);
    }

}
