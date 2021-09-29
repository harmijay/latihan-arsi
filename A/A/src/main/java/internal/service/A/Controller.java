package internal.service.A;

import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/a/")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    @ResponseBody
    public String hello(){
        return "HELLO from A";
    }

    @GetMapping("/theOther")
    @ResponseBody
    public String other(){
        return "ANOTHER API from A";
    }

    @GetMapping("/internal")
    @ResponseBody
    public String internal(){
        return "internal call to A";
    }

    @GetMapping("/callAPI/plain")
    @ResponseBody
    public Mono<?> callOtherAPI(){
        Mono<?> resp = WebClient.builder().baseUrl("http://localhost:7872").build()
                .get()
                .uri("/b/internal")
                .retrieve()
                .bodyToMono(String.class);
        return resp;
    }

    @GetMapping("/callAPI/eureka")
    @ResponseBody
    public Mono<?> callOtherAPIEureka(){
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("Bservice", false);
        Mono<?> resp = WebClient.builder().baseUrl(instanceInfo.getHomePageUrl()).build()
                .get()
                .uri("/b/internal")
                .retrieve()
                .bodyToMono(String.class);
        return resp;
    }

    @GetMapping("/sendKafka/{message}")
    public void sendMessage(@PathVariable String message) {
        this.kafkaTemplate.send("palpale",message);
    }
}
