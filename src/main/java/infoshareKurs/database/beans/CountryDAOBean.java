package infoshareKurs.database.beans;

import infoshareKurs.database.CountryStatistics;
import infoshareKurs.database.entities.CountryEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CountryDAOBean implements CountryDAOBeanLocal {

    @PersistenceContext(name = "statistics")
    EntityManager em;

    @Override
    public void addCountriesEntity(CountryEntity countryEntity) {
        em.persist(countryEntity);
        em.flush();
    }

    @Override
    public void updateCountriesEntity(CountryEntity countryEntity) {
        em.merge(countryEntity);
    }

    @Override
    public void deleteCountriesEntity(Integer id) {
        CountryEntity countryEntity = em.find(CountryEntity.class, id);
        if (countryEntity != null) {
            em.remove(countryEntity);
        }
    }

    @Override
    public List<CountryStatistics> countryQueryList() {
        Query query = em.createNamedQuery("countriesQueryDsc");
        List<Object[]> rows = query.getResultList();
        List<CountryStatistics> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            CountryStatistics countryStatistics = new CountryStatistics();
            countryStatistics.setName((row[0].toString()));
            countryStatistics.setNumber(Integer.parseInt(row[1].toString()));
            result.add(countryStatistics);
        }
        return result;
    }
}