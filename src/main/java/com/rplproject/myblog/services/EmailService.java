package com.rplproject.myblog.services;

import com.rplproject.myblog.entities.Usuarios;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmailService {
    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Usuarios usuarios, String newPass);
}
