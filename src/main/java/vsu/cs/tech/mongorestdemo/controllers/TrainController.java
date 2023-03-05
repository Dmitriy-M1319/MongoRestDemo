package vsu.cs.tech.mongorestdemo.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;
import vsu.cs.tech.mongorestdemo.services.TrainService;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainService service;

    @GetMapping("/trains")
    public List<Train> findAll() {
        return service.getAllTrains();
    }

    @GetMapping("/trains/{id}")
    public ResponseEntity<?> findTrainById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getTrainById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @GetMapping("/trains/number/{number}")
    public ResponseEntity<?> findTrainByNumber(@PathVariable Integer number) {
        try {
            return ResponseEntity.ok(service.getTrainByNumber(number));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PostMapping("/trains/create")
    public ResponseEntity<?> createTrain(@RequestBody Train train) {
        try {
            return ResponseEntity.ok(service.addTrain(train));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/trains/{id}/update")
    public ResponseEntity<?> updateTrain(@PathVariable Integer id, @RequestBody Train train) {
        try {
            return ResponseEntity.ok(service.updateExistingTrain(id, train));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/trains/{id}/delete")
    public ResponseEntity<?> deleteTrain(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deleteExistingTrain(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
