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
@Table(name = "trains")
public class Train implements Serializable {
    @Id
    @GeneratedValue()
    @Column(name = "train_id")
    private Long trainId;
    @Column
    private int number;

    @OneToMany(mappedBy = "train")
    @JsonIgnore
    private List<MetroTimetable> timetables;

    public Train(int number) {
        this.number = number;
    }
}
