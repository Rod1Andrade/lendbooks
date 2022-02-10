package com.github.rod1andrade.lendbookbackend.features.auth.external.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.ConfirmAccountMail;
import com.github.rod1andrade.lendbookbackend.features.auth.external.models.MailModel;
import com.github.rod1andrade.lendbookbackend.features.auth.infra.events.IDispatchConfirmMailEvent;
import com.github.rod1andrade.lendbookbackend.queues.QueueSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class DispatchConfirmMailEvent implements IDispatchConfirmMailEvent {

    private final QueueSender queueSender;

    @Override
    public void apply(ConfirmAccountMail confirmAccountMail) {
        try {
            String mailAsString = new ObjectMapper().writeValueAsString(
                    MailModel.builder()
                            .mailTo(confirmAccountMail.getMailTo().getValue())
                            .subject(confirmAccountMail.getSubject())
                            .text(confirmAccountMail.getText())
                            .build()
            );

            queueSender.send(new ObjectMapper().readValue(mailAsString, Map.class), "sendmailqueue");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
