package vsu.cs.tech.mongorestdemo.models;

import lombok.Data;
import java.time.LocalTime;

@Data
public class TrainStationDto {
    private int trainNumber;
    private String stationName;
    private String stationColor;
    private LocalTime timetable;
}
