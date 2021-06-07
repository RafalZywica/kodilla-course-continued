package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {
    @Value("${company.name}")
    private String companyName;
    @Value("${company.mail}")
    private String companyEmail;
    @Value("${company.phonenumber}")
    private String companyTelephone;
    @Value("${company.address}")
    private String companyAddress;
}
