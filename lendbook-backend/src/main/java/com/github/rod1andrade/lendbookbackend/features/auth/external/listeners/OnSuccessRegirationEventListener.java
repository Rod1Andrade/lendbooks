package com.github.rod1andrade.lendbookbackend.features.auth.external.listeners;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.ports.UserOutputData;
import com.github.rod1andrade.lendbookbackend.features.auth.external.event.OnSuccessRegistrationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnSuccessRegirationEventListener implements ApplicationListener<OnSuccessRegistrationEvent> {

    private final JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(OnSuccessRegistrationEvent event) {
        UserOutputData user = (UserOutputData) event.getOutputData();
        var simpleMailMessage = new SimpleMailMessage();

        String msg = "To confirm your account, please click in link below: " + event.getAppUrl() + "/auth" +
                "/confirmAccount" +
                "?token=" + user.getToken();

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("LeendBooks: Account email confirmation.");
        simpleMailMessage.setText(msg);

        javaMailSender.send(simpleMailMessage);
    }
}
