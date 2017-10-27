package infoshareKurs.database.beans;

import infoshareKurs.database.StationStatistics;
import infoshareKurs.database.entities.StationEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StationDAOBeanLocal {
    void addStationEntity(StationEntity stationEntity);

    void updateStationEntity(StationEntity stationEntity);

    void deleteStationEntity(Integer id);

    List<StationStatistics> stationQueryList();
}
