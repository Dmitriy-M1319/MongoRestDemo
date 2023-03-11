package vsu.cs.tech.mongorestdemo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.repositories.MetroTimetableRepository;

import java.util.List;

@Service
public class MetroTimetableService {

    private final TrainService trainService;
    private final StationService stationService;
    private final MetroTimetableRepository repository;

    public MetroTimetableService(TrainService trainService, StationService stationService, MetroTimetableRepository repository) {
        this.trainService = trainService;
        this.stationService = stationService;
        this.repository = repository;
    }

    public List<MetroTimetable> getAllTimetables() {
        return repository.findAll();
    }

    public MetroTimetable getTimetableById(Integer id) throws IllegalArgumentException {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Такого расписания не существует"));
    }

    public List<MetroTimetable> getTimetablesForTrain(Integer trainId) {
        return repository.findAllByTrainId(trainId);
    }

    public List<MetroTimetable> getTimetablesForStation(Integer stationId) {
        return repository.findAllByStationId(stationId);
    }

    public MetroTimetable addTimetable(MetroTimetable newTimetable, Integer trainId, Integer stationId) throws IllegalArgumentException{
        newTimetable.setTrain(trainService.getTrainById(trainId));
        newTimetable.setStation(stationService.getStationById(stationId));
        return repository.save(newTimetable);
    }

    public MetroTimetable updateExistingTimetable(Integer id,
                                                  MetroTimetable newTimetable,
                                                  Integer stationId,
                                                  Integer trainId)  throws IllegalArgumentException {
        return repository.findById(id).map(t -> {
            if (trainId > 0) {
                t.setTrain(trainService.getTrainById(trainId));
            }
            if (stationId > 0) {
                t.setStation(stationService.getStationById(stationId));
            }
            t.setTimetable(newTimetable.getTimetable());
            return repository.save(t);
        }).orElseThrow(() -> new IllegalArgumentException("Такого расписания не существует"));
    }

    public ResponseEntity<?> deleteExistingTimetable(Integer id) {
        return repository.findById(id).map(t -> {
            repository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("Такого расписания не существует"));
    }
}
