package vsu.cs.tech.mongorestdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainRepository repository;

    @GetMapping("/trains")
    public List<Train> findAll() {
        return repository.findAll();
    }

    @GetMapping("/trains/{id}")
    public Train findTrainById(@PathVariable Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Такого поезда не найдено"));
    }

    @GetMapping("/trains/number/{number}")
    public Train findTrainByNumber(@PathVariable Integer number) {
        return repository.findTrainByNumber(number);
    }
}
