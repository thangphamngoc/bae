package com.bae;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableScheduling
@SpringBootApplication
public class BaeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BaeApplication.class, args);
    }
    @Override
    public void run(String... args) throws IOException {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------DEMO APPLICATION STARTED---------------");
        System.out.println();
    }
}
