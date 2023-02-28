package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface MetroTimetableRepository extends MongoRepository<MetroTimetable, Integer> {
    Optional<MetroTimetable> findById(Integer id);
    List<MetroTimetable> findAll();
    @Query("{'time':  ?0}")
    List<MetroTimetable> findAllByTime(LocalTime time);
    @Query("{'train_id':  ?0}")
    List<MetroTimetable> findAllByTrainId(Integer trainId);
    @Query("{'station_id':  ?0}")
    List<MetroTimetable> findAllByStationId(Integer stationId);
}
