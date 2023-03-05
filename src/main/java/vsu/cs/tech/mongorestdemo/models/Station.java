package vsu.cs.tech.mongorestdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stations")
public class Station implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "station_id")
    private int stationId;
    @Column
    private String name;
    @Column
    private String color;

    @OneToMany(mappedBy = "station")
    @JsonIgnore
    private List<MetroTimetable> timetableList;;

    public Station(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
