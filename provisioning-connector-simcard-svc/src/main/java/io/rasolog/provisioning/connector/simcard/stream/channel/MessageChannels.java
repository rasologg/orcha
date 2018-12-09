package io.rasolog.provisioning.connector.simcard.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageChannels {
    String reserveSimCardConsumer = "reserveSimCardConsumer";

    @Input(reserveSimCardConsumer)
    SubscribableChannel reserveSimCardConsumer();
}
