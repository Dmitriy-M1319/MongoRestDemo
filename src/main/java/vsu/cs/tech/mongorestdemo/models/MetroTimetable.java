package vsu.cs.tech.mongorestdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "metro_timetables")
public class MetroTimetable implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id")
    private Train train;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", referencedColumnName = "station_id")
    private Station station;
    @Column
    private LocalTime time;

    public MetroTimetable(Train train, Station station, LocalTime time) {
        this.train = train;
        this.station = station;
        this.time = time;
    }
}

