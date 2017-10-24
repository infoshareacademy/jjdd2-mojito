package infoshareKurs.database.beans;

import infoshareKurs.database.entities.CitiesEntity;
import infoshareKurs.database.entities.CountriesEntity;

import javax.ejb.Local;
import java.util.List;


@Local
public interface CountriesDAOBeanLocal {
    void addCountriesEntity(CountriesEntity countriesEntity);

    void updateCountriesEntity(CountriesEntity countriesEntity);

    void deleteCountriesEntity(Integer id);

    List<String> countryQueryList();

}
