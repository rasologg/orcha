package io.rasolog.provisioning.connector.crm.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageChannels {
    String notifyCustomerConsumer = "notifyCustomerConsumer";

    @Input(notifyCustomerConsumer)
    SubscribableChannel notifyCustomerConsumer();

}
