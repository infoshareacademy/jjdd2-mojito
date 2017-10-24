package infoshareKurs.database.beans;

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
    public List<String> cityQueryList() {
        List<String> result = new ArrayList<>();
        Query query = em.createQuery("SELECT c.name ,SUM(c.number) FROM CitiesEntity c GROUP BY c.name ORDER BY (sum(c.number)) desc");
        List<Object[]> queryResult = query.getResultList();
        for (Object[] obj : queryResult) {
            result.add((obj[0]) + String.valueOf(obj[1]));
        }
        return result;
    }
}
