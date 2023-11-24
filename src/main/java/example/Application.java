package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.uppercase.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Config.class, args);
    }
}
