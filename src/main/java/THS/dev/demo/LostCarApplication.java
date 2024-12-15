package THS.dev.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LostCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostCarApplication.class, args);
	}

}
