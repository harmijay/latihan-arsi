package internal.service.C;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CApplication {

	public static void main(String[] args) {
		SpringApplication.run(CApplication.class, args);
	}

}
