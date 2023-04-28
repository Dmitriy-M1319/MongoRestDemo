package vsu.cs.tech.mongorestdemo.repositories;

import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;

import java.time.LocalTime;

@Repository
public interface MetroJdbcRepository extends JpaRepository<MetroTimetable, Long> {
    @Query(value = "insert into metro_timetable(train_id, station_id, timetable) " +
            "values (:trainId, :stationId, :time) " +
            "on conflict(train_id, station_id) do update set train_id = excluded.train_id, " +
            "station_id = excluded.station_id RETURNING id;", nativeQuery=true)
    Long saveCustom(@Param("trainId") Long trainId, @Param("stationId") Long stationId, @Param("time") LocalTime time);
}
