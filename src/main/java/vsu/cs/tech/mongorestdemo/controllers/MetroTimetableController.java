package vsu.cs.tech.mongorestdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.repositories.MetroTimetableRepository;
import vsu.cs.tech.mongorestdemo.repositories.StationRepository;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;
import vsu.cs.tech.mongorestdemo.services.MetroTimetableService;

import java.util.List;

@RestController
public class MetroTimetableController {

    @Autowired
    private MetroTimetableRepository metroTimetableRepository;
    @Autowired
    private MetroTimetableService service;
    @GetMapping("/timetable")
    public List<MetroTimetable> findAll() {
        List<MetroTimetable> result = metroTimetableRepository.findAll();
        return service.getListOfFullTimetables(result);
    }

    @GetMapping("/timetable/{id}")
    public MetroTimetable findTimetableById(@PathVariable Integer id) throws Exception{
       MetroTimetable result = metroTimetableRepository.findById(id)
               .orElseThrow(() -> new Exception("Такого расписания не найдено"));
       return service.getFullTimetable(result);
    }

    @GetMapping("/timetable/train/{id}")
    public List<MetroTimetable> findTimetablesByTrainId(@PathVariable Integer id) {
        List<MetroTimetable> results = metroTimetableRepository.findAllByTrainId(id);
        return service.getListOfFullTimetables(results);
    }
    @GetMapping("/timetable/station/{id}")
    public List<MetroTimetable> findTimetablesByStationId(@PathVariable Integer id) {
        List<MetroTimetable> results = metroTimetableRepository.findAllByStationId(id);
        return service.getListOfFullTimetables(results);
    }
}
