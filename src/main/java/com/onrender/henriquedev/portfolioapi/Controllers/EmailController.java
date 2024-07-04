package com.onrender.henriquedev.portfolioapi.Controllers;

import com.onrender.henriquedev.portfolioapi.Models.EmailModel;
import com.onrender.henriquedev.portfolioapi.Services.EmailService;
import com.onrender.henriquedev.portfolioapi.Services.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<Integer> sendEmail(@RequestBody EmailModel request) {
        try {
            if (!EmailValidator.isValid(request.getClientEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
            } else {
                emailService.sendEmail(request);
                return ResponseEntity.status(HttpStatus.OK).body(200);
            }
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(500);
        }
    }
}
