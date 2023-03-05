package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface MetroTimetableRepository extends JpaRepository<MetroTimetable, Integer> {
    Optional<MetroTimetable> findById(Integer id);
    List<MetroTimetable> findAll();
    @Query(value = "select m from MetroTimetable m where m.time = ?1")
    List<MetroTimetable> findAllByTime(LocalTime time);
    @Query(value = "select m from MetroTimetable m where m.train.trainId = ?1")
    List<MetroTimetable> findAllByTrainId(Integer trainId);
    @Query(value = "select m from MetroTimetable m where m.station.stationId= ?1")
    List<MetroTimetable> findAllByStationId(Integer stationId);
}
