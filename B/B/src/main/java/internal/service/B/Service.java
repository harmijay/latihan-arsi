package internal.service.B;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@org.springframework.stereotype.Service
public class Service {
    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @KafkaListener(id="myId", topics = "palpale")
    public void listenGroupFoo(String message) {
        logger.info("Received Message in group foo: " + message);
    }
}
