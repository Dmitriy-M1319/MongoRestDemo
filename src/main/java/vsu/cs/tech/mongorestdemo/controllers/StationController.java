package vsu.cs.tech.mongorestdemo.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.services.StationService;

import java.io.Serializable;
import java.util.List;

@RestController
public class StationController {
    @Autowired
    private StationService service;

    @GetMapping("/stations")
    public List<Station> findAllStations() {
        return service.getAllStations();
    }

    @GetMapping("/stations/{id}")
    public ResponseEntity<?> findStationById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getStationById(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
    @GetMapping("/stations/color/{color}")
    public List<Station> findStationsByColor(@PathVariable String color) {
        return service.getStationsByColor(color);
    }

    @GetMapping("/stations/name/{name}")
    public ResponseEntity<?> findStationByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(service.getStationByName(name));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
    @PostMapping("/stations/create")
    public ResponseEntity<?> createStation(@RequestBody Station station) {
        try {
            return ResponseEntity.ok(service.addStation(station));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @PutMapping("/stations/{id}/update")
    public ResponseEntity<?> updateStation(@PathVariable Integer id, @RequestBody Station station) {
        try {
            return ResponseEntity.ok(service.updateExistingStation(id, station));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }

    @DeleteMapping("/stations/{id}/delete")
    public ResponseEntity<?> deleteStation(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.deleteExistingStation(id));
        } catch (IllegalArgumentException e) {
            JSONObject resp = new JSONObject();
            resp.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(resp);
        }
    }
}
