package io.rasolog.provisioning;

import org.activiti.cloud.services.events.ProcessEngineChannels;
import org.activiti.cloud.starter.rb.configuration.ActivitiRuntimeBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@ActivitiRuntimeBundle
@EnableBinding({ProcessEngineChannels.class})
public class ProvisioningRuntimeBundleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvisioningRuntimeBundleApplication.class, args);
    }



}