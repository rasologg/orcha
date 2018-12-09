package io.rasolog.provisioning.audit;

import org.activiti.cloud.starter.audit.configuration.EnableActivitiAudit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableActivitiAudit
public class AuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }
}
