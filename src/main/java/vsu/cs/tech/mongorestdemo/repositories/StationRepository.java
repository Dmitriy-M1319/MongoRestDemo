package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vsu.cs.tech.mongorestdemo.models.Station;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
    List<Station> findAll();

    Optional<Station> findById(Integer id);
    @Query(value = "select s from Station s where s.color = ?1")
    List<Station> findAllByColor(String color);

    @Query(value = "select s from Station s where s.name = ?1")
    Optional<Station> findByName(String name);
}
