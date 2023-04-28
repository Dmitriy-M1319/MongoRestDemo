package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsu.cs.tech.mongorestdemo.models.Station;

@Repository
public interface StationJdbcRepository extends JpaRepository<Station, Long> {
    @Query(value = "insert into stations(name, color) " +
            "values (:name, :color) RETURNING id;", nativeQuery=true)
    Long saveCustom(@Param("name") String name, @Param("color") String color);
}
