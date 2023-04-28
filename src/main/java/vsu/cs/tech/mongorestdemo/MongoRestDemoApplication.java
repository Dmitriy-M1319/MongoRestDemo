package vsu.cs.tech.mongorestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vsu.cs.tech.mongorestdemo.repositories.TrainJdbcRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = TrainJdbcRepository.class)
public class MongoRestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoRestDemoApplication.class, args);
    }

}
