package infoshareKurs.database.beans;

import infoshareKurs.database.CityStatistics;
import infoshareKurs.database.entities.CityEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CityDAOBeanLocal {
    void addCitiesEntity(CityEntity cityEntity);

    void updateCitiesEntity(CityEntity cityEntity);

    void deleteCitiesEntity(Integer id);

    List<CityStatistics> cityQueryList();
}
