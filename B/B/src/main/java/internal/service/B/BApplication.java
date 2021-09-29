package internal.service.B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BApplication {

	public static void main(String[] args) {
		SpringApplication.run(BApplication.class, args);
	}

}
