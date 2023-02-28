package vsu.cs.tech.mongorestdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.repositories.StationRepository;

import java.util.List;

@RestController
public class StationController {
    @Autowired
    private StationRepository repository;

    @GetMapping("/stations")
    public List<Station> findAllStations() {
        return repository.findAll();
    }

    @GetMapping("/stations/{id}")
    public Station findStationById(@PathVariable Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Такой станции не найдено"));
    }
    @GetMapping("/stations/color/{color}")
    public List<Station> findStationsByColor(@PathVariable String color) {
        return repository.findAllByColor(color);
    }

    @GetMapping("/stations/name/{name}")
    public Station findStationByName(@PathVariable String name) {
        return repository.findByName(name);
    }
}
