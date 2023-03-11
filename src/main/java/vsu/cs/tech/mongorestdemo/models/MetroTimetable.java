package vsu.cs.tech.mongorestdemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metro_timetable")
public class MetroTimetable implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Train train;
    @ManyToOne()
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    private Station station;
    @Column(name = "timetable")
    private LocalTime timetable;

}

