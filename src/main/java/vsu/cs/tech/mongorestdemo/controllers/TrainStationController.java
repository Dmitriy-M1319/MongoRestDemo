package vsu.cs.tech.mongorestdemo.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vsu.cs.tech.mongorestdemo.models.TrainStationDto;
import vsu.cs.tech.mongorestdemo.services.TrainStationDataService;

@RestController
@RequestMapping(path = "/train-station",
        produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class TrainStationController {

    private final TrainStationDataService service;

    public TrainStationController(TrainStationDataService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody TrainStationDto dto) {
        //service.createTimetable(dto);
        long trainId = service.createTrain(dto);
        long stationId = service.createStation(dto);
        long id = service.createTimetable(trainId, stationId, dto);
        return ResponseEntity.ok(String.valueOf(id));
    }
}
