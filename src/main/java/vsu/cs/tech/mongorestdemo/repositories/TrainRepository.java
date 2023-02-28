package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vsu.cs.tech.mongorestdemo.models.Train;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends MongoRepository<Train, Integer> {
    List<Train> findAll();
    Optional<Train> findById(Integer id);

    @Query("{'number' : ?0}")
    Train findTrainByNumber(Integer number);
}
