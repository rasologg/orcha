package io.rasolog.provisioning.connector.mobilentw.stream.listener;

import io.rasolog.provisioning.connector.mobilentw.stream.channel.MessageChannels;
import lombok.extern.slf4j.Slf4j;
import org.activiti.cloud.connectors.starter.channels.IntegrationResultSender;
import org.activiti.cloud.connectors.starter.configuration.ConnectorProperties;
import org.activiti.cloud.connectors.starter.model.IntegrationResultBuilder;
import org.activiti.cloud.api.process.model.IntegrationRequest;
import org.activiti.cloud.api.process.model.IntegrationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@EnableBinding(MessageChannels.class)
public class MessageListeners {

    private final IntegrationResultSender integrationResultSender;

    @Autowired
    private ConnectorProperties connectorProperties;

    @Autowired
    MessageChannels messageChannels;

    public MessageListeners(IntegrationResultSender integrationResultSender) {
        this.integrationResultSender = integrationResultSender;
    }

    @StreamListener(value = MessageChannels.provisionMobileNetworkConsumer)
    public void provisionMobileNetworkConsumer(IntegrationRequest event){
        String customerId = String.valueOf(event.getIntegrationContext().getInBoundVariables().get("customer_id"));
        String simcardId = String.valueOf(event.getIntegrationContext().getInBoundVariables().get("simcard_id"));
        log.info("Provision mobile network for Simcard {} for customer {}", simcardId, customerId);
        Map<String, Object> results = new HashMap<>();
        results.put("customer_id", customerId);
        results.put("simcard_id", simcardId);
        results.put("mobile_network_status", "ACTIVATED");
        Message<IntegrationResult> message = IntegrationResultBuilder.resultFor(event, connectorProperties)
                .withOutboundVariables(results)
                .buildMessage();
        integrationResultSender.send(message);
    }

}