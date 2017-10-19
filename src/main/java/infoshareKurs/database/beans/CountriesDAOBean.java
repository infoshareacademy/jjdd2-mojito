package infoshareKurs.database.beans;

import infoshareKurs.database.entities.CountriesEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless

public class CountriesDAOBean implements CountriesDAOBeanLocal {

    @PersistenceContext(name = "statistics")
    EntityManager em;

    @Override
    public void addCountriesEntity(CountriesEntity countriesEntity) {
        em.persist(countriesEntity);
        em.flush();
    }

    @Override
    public void updateCountriesEntity(CountriesEntity countriesEntity) {
        em.merge(countriesEntity);
    }

    @Override
    public void deleteCountriesEntity(Integer id) {
        CountriesEntity countriesEntity = em.find(CountriesEntity.class, id);
        if (countriesEntity != null) {
            em.remove(countriesEntity);
        }
    }

}
