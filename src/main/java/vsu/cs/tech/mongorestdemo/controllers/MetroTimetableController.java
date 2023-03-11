package vsu.cs.tech.mongorestdemo.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.repositories.MetroTimetableRepository;
import vsu.cs.tech.mongorestdemo.services.MetroTimetableService;

import java.util.List;

@RestController
public class MetroTimetableController {

    private MetroTimetableService service;

    public MetroTimetableController(MetroTimetableService service) {
        this.service = service;
    }

    @GetMapping("/timetable")
    public List<MetroTimetable> findAll() {
        return service.getAllTimetables();
    }

    @GetMapping("/timetable/{id}")
    public ResponseEntity<?> findTimetableById(@PathVariable Integer id) throws Exception{
        try {
            return ResponseEntity.ok(service.getTimetableById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @GetMapping("/trains/{id}/timetable")
    public List<MetroTimetable> findTimetablesByTrainId(@PathVariable Integer id) {
        return service.getTimetablesForTrain(id);
    }

    @GetMapping("/stations/{id}/timetable")
    public List<MetroTimetable> findTimetablesByStationId(@PathVariable Integer id) {
        return service.getTimetablesForStation(id);
    }

    @PostMapping("/timetable/create/train/{trainId}/station/{stationId}")
    public ResponseEntity<?> createNewTimetable(@PathVariable Integer trainId, @PathVariable Integer stationId, @RequestBody MetroTimetable timetable) {
        try {
            return ResponseEntity.ok(service.addTimetable(timetable, trainId, stationId));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/timetable/{id}/update")
    public ResponseEntity<?> updateTimetable(@PathVariable Integer id,
                                             @RequestParam(value = "train_id") Integer trainId,
                                             @RequestParam(value = "station_id") Integer stationId,
                                             @RequestBody MetroTimetable timetable) {
        try {
            return ResponseEntity.ok(service.updateExistingTimetable(id, timetable, trainId, stationId));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/timetable/{id}/delete")
    public ResponseEntity<?> deleteTimetable(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deleteExistingTimetable(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
