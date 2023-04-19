package vsu.cs.tech.mongorestdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stations")
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer stationId;
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
