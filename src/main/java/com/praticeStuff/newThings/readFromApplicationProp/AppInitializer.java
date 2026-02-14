package com.praticeStuff.newThings.readFromApplicationProp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer implements CommandLineRunner {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Normal @value "+appName);
        System.out.println("using  configprop "+applicationProperties);
        System.out.println("using  configprop "+applicationProperties);
    }
}
