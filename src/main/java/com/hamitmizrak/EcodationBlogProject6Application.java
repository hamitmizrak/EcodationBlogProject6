package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        //org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
//@SpringBootApplication

//Auditing
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

public class EcodationBlogProject6Application {
    public static void main(String[] args) {
        //Disables headless JOptionPane
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(EcodationBlogProject6Application.class, args);
    }
}
