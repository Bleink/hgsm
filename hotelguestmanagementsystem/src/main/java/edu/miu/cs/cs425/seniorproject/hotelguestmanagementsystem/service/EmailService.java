package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.EmailConfirmation;

public interface EmailService {
    public String sendEmail(EmailConfirmation emailConfirmation);
}
