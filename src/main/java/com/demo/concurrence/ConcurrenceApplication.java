package com.demo.concurrence;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class ConcurrenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrenceApplication.class, args);
    }

}
