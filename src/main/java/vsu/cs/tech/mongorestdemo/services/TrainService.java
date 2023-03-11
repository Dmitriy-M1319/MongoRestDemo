package vsu.cs.tech.mongorestdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository repository;


    public List<Train> getAllTrains() {
        return repository.findAll();
    }

    public Train getTrainById(Integer id) throws IllegalArgumentException {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Такого номера поезда не существует"));
    }

    public Train getTrainByNumber(Integer number) throws IllegalArgumentException {
        return repository.findTrainByNumber(number).orElseThrow(() -> new IllegalArgumentException("Такого номера поезда не существует"));
    }

    public Train addTrain(Train newTrain) {
        return repository.save(newTrain);
    }

    public Train updateExistingTrain(Integer id, Train newTrain) throws IllegalArgumentException {
        return repository.findById(id).map(t -> {
            t.setNumber(newTrain.getNumber());
            return repository.save(t);
        }).orElseThrow(() -> new IllegalArgumentException("Такого поезда не существует"));
    }

    public ResponseEntity<?> deleteExistingTrain(Integer id) throws IllegalArgumentException {
       return repository.findById(id).map(t -> {
           repository.delete(t);
           return ResponseEntity.ok().build();
       }).orElseThrow(() -> new IllegalArgumentException("Такого поезда не существует"));
    }
}
