package io.rasolog.provisioning.query;

import org.activiti.cloud.starter.query.configuration.EnableActivitiQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableActivitiQuery
public class QueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class, args);
    }
    
}