package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksServiceConfiguration {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BooksServiceConfiguration.class);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }

}
