package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        //org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
//@SpringBootApplication

public class EcodationBlogProject6Application {

    public static void main(String[] args) {

        //Disables headless JOptionPane
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(EcodationBlogProject6Application.class, args);
    }

}
