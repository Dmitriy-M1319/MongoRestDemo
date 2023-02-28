package vsu.cs.tech.mongorestdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.repositories.StationRepository;
import vsu.cs.tech.mongorestdemo.repositories.TrainRepository;

import java.util.List;

@Service
public class MetroTimetableService {

    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private StationRepository stationRepository;

    public MetroTimetable getFullTimetable(MetroTimetable smallTable) {
        smallTable.setTrain(trainRepository.findById(Integer.parseInt(smallTable.getTrain_id())).orElse(null));
        smallTable.setStation(stationRepository.findById(Integer.parseInt(smallTable.getStation_id())).orElse(null));
        return smallTable;
    }

    public List<MetroTimetable> getListOfFullTimetables(List<MetroTimetable> smallTables) {
        for (MetroTimetable m: smallTables) {
            m = getFullTimetable(m);
        }
        return smallTables;
    }

}
