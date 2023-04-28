package vsu.cs.tech.mongorestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vsu.cs.tech.mongorestdemo.models.Train;

@Repository
public interface TrainJdbcRepository extends JpaRepository<Train, Long> {
    @Query(value = "insert into trains(train_number) values (?1) on conflict(train_number)" +
            " do update set train_number = excluded.train_number RETURNING id", nativeQuery=true)
    Integer saveCustom(Integer number);
}
