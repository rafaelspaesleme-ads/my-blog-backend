package com.rplproject.myblog.configurations;

import com.rplproject.myblog.services.EmailService;
import com.rplproject.myblog.services.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {
    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
