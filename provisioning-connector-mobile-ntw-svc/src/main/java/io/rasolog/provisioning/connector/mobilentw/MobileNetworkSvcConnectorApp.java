package io.rasolog.provisioning.connector.mobilentw;

import org.activiti.cloud.connectors.starter.configuration.EnableActivitiCloudConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableActivitiCloudConnector
@ComponentScan({"org.activiti.cloud.connectors.starter","org.activiti.cloud.services.common.security","io.rasolog.provisioning"})
public class MobileNetworkSvcConnectorApp {

    public static void main(String[] args) {
        SpringApplication.run(MobileNetworkSvcConnectorApp.class, args);
    }
}
