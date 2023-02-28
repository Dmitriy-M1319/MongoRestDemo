package vsu.cs.tech.mongorestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import vsu.cs.tech.mongorestdemo.repositories.MetroTimetableRepository;
import vsu.cs.tech.mongorestdemo.repositories.StationRepository;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {
        TrainRepository.class, StationRepository.class, MetroTimetableRepository.class
})
public class MongoRestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoRestDemoApplication.class, args);
    }

}
