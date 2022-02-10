package com.github.rod1andrade.lendbookbackend.features.mail.external.events;

import com.github.rod1andrade.lendbookbackend.features.mail.core.entities.Mail;
import com.github.rod1andrade.lendbookbackend.features.mail.core.exceptions.DispatchMailServiceException;
import com.github.rod1andrade.lendbookbackend.features.mail.infra.events.IDispatchMailEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DispatchMailEvent implements IDispatchMailEvent {

    private final JavaMailSender javaMailSender;

    @Override
    public void send(Mail mail) {
        try {
            var simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(mail.getMailTo());
            simpleMailMessage.setSubject(mail.getSubject());
            simpleMailMessage.setText(mail.getText());

            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.info("Dispatch Mail Service: {}", e.getMessage());
            throw new DispatchMailServiceException("Não foi possível enviar o e-mail");
        }
    }
}
