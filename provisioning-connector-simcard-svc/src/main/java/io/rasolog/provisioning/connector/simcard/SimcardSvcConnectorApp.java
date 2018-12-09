package io.rasolog.provisioning.connector.simcard;

import org.activiti.cloud.connectors.starter.configuration.EnableActivitiCloudConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableActivitiCloudConnector
@ComponentScan({"org.activiti.cloud.connectors.starter","org.activiti.cloud.services.common.security","io.rasolog.provisioning"})
public class SimcardSvcConnectorApp {

    public static void main(String[] args) {
        SpringApplication.run(SimcardSvcConnectorApp.class, args);
    }
}
