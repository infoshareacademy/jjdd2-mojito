package infoshareKurs.database.beans;
import infoshareKurs.database.CitiesQueryListValues;
import infoshareKurs.database.entities.CitiesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CitiesDAOBean implements CitiesDAOBeanLocal {


    @PersistenceContext(name = "statistics")
    EntityManager em;

    @Override

    public void addCitiesEntity(CitiesEntity citiesEntity) {
        em.persist(citiesEntity);
    }

    @Override
    public void updateCitiesEntity(CitiesEntity citiesEntity) {
        em.merge(citiesEntity);
    }

    @Override
    public void deleteCitiesEntity(Integer id) {
        CitiesEntity citiesEntity = em.find(CitiesEntity.class, id);
        if (citiesEntity != null) {
            em.remove(citiesEntity);
        }
    }

    @Override
    public List<CitiesQueryListValues> cityQueryList() {
        Query query = em.createQuery("SELECT c.name ,SUM(c.number) FROM CitiesEntity c GROUP BY c.name ORDER BY (sum(c.number)) desc");
        List<Object[]> rows = query.getResultList();
        List<CitiesQueryListValues> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            CitiesQueryListValues citiesQueryListValues =new CitiesQueryListValues();
            citiesQueryListValues.setName((row[0].toString()));
            citiesQueryListValues.setNumber(row[1].toString());
            result.add(citiesQueryListValues);
        }
        return result;
    }
}