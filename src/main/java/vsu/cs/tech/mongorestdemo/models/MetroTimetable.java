package vsu.cs.tech.mongorestdemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.TimeSeries;

import java.time.LocalTime;

@TimeSeries(collection = "metro_timetable", timeField = "time")
public class MetroTimetable {
    @Id
    private int id;

    private Train train;
    private String train_id;
    private Station station;
    private String station_id;
    private LocalTime time;

    public MetroTimetable(String train_id, String station_id, LocalTime time) {
        this.train_id = train_id;
        this.station_id = station_id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

