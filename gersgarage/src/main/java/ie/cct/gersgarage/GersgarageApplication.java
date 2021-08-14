package ie.cct.gersgarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("ie.cct*")
public class GersgarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GersgarageApplication.class, args);
	}

}
