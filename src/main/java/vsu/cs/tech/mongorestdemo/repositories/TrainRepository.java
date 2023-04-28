package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vsu.cs.tech.mongorestdemo.models.Train;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
    List<Train> findAll();
    Optional<Train> findById(Integer id);

    @Query(value = "select t from Train t where t.trainNumber = ?1")
    Optional<Train> findTrainByNumber(Integer number);
}
