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
@Table(name = "trains")
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer trainId;
    @Column
    private Integer trainNumber;

    @OneToMany(mappedBy = "train")
    @JsonIgnore
    private List<MetroTimetable> timetables;

    public Train(int trainNumber) {
        this.trainNumber = trainNumber;
    }
}
