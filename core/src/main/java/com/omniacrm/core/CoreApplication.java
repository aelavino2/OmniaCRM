package com.omniacrm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CoreApplication.class);
        application.addInitializers(context -> context.getEnvironment()
                .setRequiredProperties("POSTGRES_DB", "POSTGRES_USER", "POSTGRES_PASSWORD"));
        application.run(args);
    }
}
