package vsu.cs.tech.mongorestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MongoRestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoRestDemoApplication.class, args);
    }

}
