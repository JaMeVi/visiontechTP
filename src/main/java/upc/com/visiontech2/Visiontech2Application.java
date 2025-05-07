package upc.com.visiontech2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Visiontech2Application {

    public static void main(String[] args) {
        SpringApplication.run(Visiontech2Application.class, args);
    }

}
