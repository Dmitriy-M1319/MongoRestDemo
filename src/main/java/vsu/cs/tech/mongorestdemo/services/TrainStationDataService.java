package vsu.cs.tech.mongorestdemo.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.models.TrainStationDto;

import java.sql.PreparedStatement;

@Service
public class TrainStationDataService {

    private final JdbcTemplate template;
    private final TrainService trainService;
    private final StationService stationService;
    private final MetroTimetableService metroService;

    public TrainStationDataService(JdbcTemplate template,
                                   TrainService trainService,
                                   StationService stationService,
                                   MetroTimetableService metroService) {
        this.template = template;
        this.trainService = trainService;
        this.stationService = stationService;
        this.metroService = metroService;
    }

    public long createTrain(TrainStationDto dto) {
        String insertQuery = "INSERT INTO trains(number) VALUES(?)";
        KeyHolder holder = new GeneratedKeyHolder();;
        template.update(connection -> {
            PreparedStatement ps  = connection
                    .prepareStatement(insertQuery);
            ps.setInt(1, dto.getTrainNumber());
            return ps;
        }, holder);
        return (long) holder.getKey();
    }

    public long createStation(TrainStationDto dto) {
        String insertQuery = "INSERT INTO stations(name, color) VALUES(?, ?)";
        KeyHolder holder = new GeneratedKeyHolder();;
        template.update(connection -> {
            PreparedStatement ps  = connection
                    .prepareStatement(insertQuery);
            ps.setString(1, dto.getStationName());
            ps.setString(2, dto.getStationColor());
            return ps;
        }, holder);
        return (long) holder.getKey();
    }

    public void createTimetable(TrainStationDto dto) {
        Train train = trainService.addTrain(new Train(dto.getTrainNumber()));
        Station station = stationService.addStation(new Station(dto.getStationName(), dto.getStationColor()));
        MetroTimetable inserted = new MetroTimetable();
        inserted.setTimetable(dto.getTimetable());
        MetroTimetable metroTimetable = metroService.addTimetable(inserted, train.getTrainId(), station.getStationId());
    }
}
