package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vsu.cs.tech.mongorestdemo.models.Station;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends MongoRepository<Station, Integer> {
    List<Station> findAll();

    Optional<Station> findById(Integer id);
    @Query("{'color':  ?0}")
    List<Station> findAllByColor(String color);

    @Query("{'name':  ?0}")
    Station findByName(String name);
}
