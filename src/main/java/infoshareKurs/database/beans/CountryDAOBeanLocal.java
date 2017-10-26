package infoshareKurs.database.beans;

import infoshareKurs.database.CountryStatistics;
import infoshareKurs.database.entities.CountryEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CountryDAOBeanLocal {
    void addCountriesEntity(CountryEntity countryEntity);

    void updateCountriesEntity(CountryEntity countryEntity);

    void deleteCountriesEntity(Integer id);

    List<CountryStatistics> countryQueryList();
}
