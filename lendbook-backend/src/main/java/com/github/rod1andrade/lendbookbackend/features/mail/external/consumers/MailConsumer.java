package com.github.rod1andrade.lendbookbackend.features.mail.external.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.factories.IDispatchMailUsecaseFactory;
import com.github.rod1andrade.lendbookbackend.features.mail.core.usecases.interfaces.IDispatchMailUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailConsumer {

    private final IDispatchMailUsecaseFactory dispatchMailUsecaseFactory;

    @RabbitListener(queues = {"sendmailqueue"})
    public void receive(Map<String, Object> message) {
        log.info("QUEUE MESSAGE: {}", message);
        IDispatchMailUsecase dispatchMailUsecase = dispatchMailUsecaseFactory.create();

        dispatchMailUsecase.apply(new Mail(
                (String) message.get("mailTo"),
                (String) message.get("subject"),
                (String) message.get("text")
        ));
    }
}
