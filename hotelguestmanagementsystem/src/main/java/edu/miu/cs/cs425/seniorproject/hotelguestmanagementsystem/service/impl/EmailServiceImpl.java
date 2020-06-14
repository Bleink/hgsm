package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.EmailConfirmation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    SimpleMailMessage mailMessage;

    @Override
    public String sendEmail(EmailConfirmation emailConfirmation) {

        mailMessage.setTo(emailConfirmation.getEmail());
        mailMessage.setText(emailConfirmation.getRedirectUrl());
        mailSender.send(mailMessage);
        return "Email sent to " + " " + emailConfirmation.getEmail();
    }
}
