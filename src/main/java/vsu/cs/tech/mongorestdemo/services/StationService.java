package vsu.cs.tech.mongorestdemo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.repositories.StationRepository;

import java.util.List;

@Service
public class StationService {

    private final StationRepository repository;

    public StationService(StationRepository repository) {
        this.repository = repository;
    }

    public List<Station> getAllStations() {
        return repository.findAll();
    }

    public Station getStationById(Integer id) throws IllegalArgumentException {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Такой станции не существует"));
    }

    public List<Station> getStationsByColor(String color) {
        return repository.findAllByColor(color);
    }

    public Station getStationByName(String name ) throws IllegalArgumentException {
        return repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Такой станции не существует"));
    }

    public Station addStation(Station newStation) {
        return repository.save(newStation);
    }

    public Station updateExistingStation(Integer id, Station newStation) throws IllegalArgumentException {
        return repository.findById(id).map(s -> {
            s.setName(newStation.getName());
            s.setColor(newStation.getColor());
            return repository.save(s);
        }).orElseThrow(() -> new IllegalArgumentException("Такой станции не существует"));
    }

    public ResponseEntity<?> deleteExistingStation(Integer id) throws IllegalArgumentException {
        return repository.findById(id).map(s -> {
            repository.delete(s);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("Такой станции не существует"));
    }
}
