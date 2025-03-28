package org.hc.jds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDistributedSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaDistributedSqlApplication.class, args);
    }
}