package com.github.rod1andrade.lendbookbackend.features.auth.external.listeners;

import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserOutputData;
import com.github.rod1andrade.lendbookbackend.features.auth.external.event.OnSuccessRegistrationEvent;
import com.github.rod1andrade.lendbookbackend.queues.QueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OnSuccessRegirationEventListener implements ApplicationListener<OnSuccessRegistrationEvent> {

    private final QueueSender queueSender;

    @Override
    public void onApplicationEvent(OnSuccessRegistrationEvent event) {
        UserOutputData user = (UserOutputData) event.getOutputData();
        Map<String, Object> mail = new HashMap<>();
        mail.put("text",
                "To confirm your account, please click in link below: " + event.getAppUrl() + "/auth" +
                "/confirmAccount?token=" + user.getToken()
        );
        mail.put("subject",
                "LeendBooks: Account email confirmation."
        );
        mail.put("mailTo",
                user.getEmail()
        );

        queueSender.send(mail, "sendmailqueue");
    }
}
