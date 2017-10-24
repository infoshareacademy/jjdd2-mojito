package infoshareKurs.database.beans;

import infoshareKurs.database.CitiesQueryListValues;
import infoshareKurs.database.entities.CitiesEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CitiesDAOBeanLocal {
    void addCitiesEntity(CitiesEntity citiesEntity);

    void updateCitiesEntity(CitiesEntity citiesEntity);

    void deleteCitiesEntity(Integer id);

    List<CitiesQueryListValues> cityQueryList();
}
