package com.busiwave.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Startup for Spring Boot
 */
@SpringBootApplication
// SAME AS
// @Configuration - Spring config on startup
// @EnableAutoConfiguration - Auto Configures frameworks
// @ComponentScan - Scans project for spring components such as services, controllers, repositories or any other subpackages
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }
}
