package io.rasolog.provisioning.connector.mobilentw.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageChannels {
    String provisionMobileNetworkConsumer = "provisionMobileNetworkConsumer";

    @Input(provisionMobileNetworkConsumer)
    SubscribableChannel provisionMobileNetworkConsumer();

}
