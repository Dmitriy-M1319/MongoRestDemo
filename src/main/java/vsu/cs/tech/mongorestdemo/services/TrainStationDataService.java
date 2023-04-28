package vsu.cs.tech.mongorestdemo.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import vsu.cs.tech.mongorestdemo.models.MetroTimetable;
import vsu.cs.tech.mongorestdemo.models.Station;
import vsu.cs.tech.mongorestdemo.models.Train;
import vsu.cs.tech.mongorestdemo.models.TrainStationDto;
import vsu.cs.tech.mongorestdemo.repositories.MetroJdbcRepository;
import vsu.cs.tech.mongorestdemo.repositories.StationJdbcRepository;
import vsu.cs.tech.mongorestdemo.repositories.TrainJdbcRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainStationDataService {

    private final JdbcTemplate template;
    private final TrainJdbcRepository trainRepository;
    private final StationJdbcRepository stationRepository;
    private final MetroJdbcRepository metroRepository;

    public TrainStationDataService(JdbcTemplate template,
                                   TrainJdbcRepository repository,
                                   StationJdbcRepository stationRepository,
                                   MetroJdbcRepository metroRepository) {
        this.template = template;
        this.trainRepository = repository;
        this.stationRepository = stationRepository;
        this.metroRepository = metroRepository;
    }

    public long createTrain(TrainStationDto dto) {
        return trainRepository.saveCustom(dto.getTrainNumber());
    }

    public long createStation(TrainStationDto dto) {
        return stationRepository.saveCustom(dto.getStationName(), dto.getStationColor());
    }

    public long createTimetable(long trainId, long stationId, TrainStationDto dto) {
       return metroRepository.saveCustom(trainId, stationId, dto.getTimetable());
    }
}
