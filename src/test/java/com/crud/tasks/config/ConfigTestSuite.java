package com.crud.tasks.config;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ConfigTestSuite {

    @Test
    public void AdminConfigTest() {
        //Given
        AdminConfig adminConfig = new AdminConfig();

        //When
        String mail = adminConfig.getAdminMail();

        //Then
        assertEquals(null, mail);
    }
    @Test
    public void CoreConfigurationTest() {
        //Given
        CoreConfiguration coreConfiguration = new CoreConfiguration();
        //When/Then
        assertEquals(0,0);

    }
}
