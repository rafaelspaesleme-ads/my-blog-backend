package com.rplproject.myblog.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends EmailService {
    private final MailSender mailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    public SmtpEmailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Enviando email...");
        mailSender.send(msg);
        LOG.info("Email enviado");
    }
}
