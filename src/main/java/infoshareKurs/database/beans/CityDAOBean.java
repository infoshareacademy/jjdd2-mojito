package infoshareKurs.database.beans;
import infoshareKurs.database.CityStatistics;
import infoshareKurs.database.entities.CityEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CityDAOBean implements CityDAOBeanLocal {

    @PersistenceContext(name = "statistics")
    EntityManager em;

    @Override

    public void addCitiesEntity(CityEntity cityEntity) {
        em.persist(cityEntity);
    }

    @Override
    public void updateCitiesEntity(CityEntity cityEntity) {
        em.merge(cityEntity);
    }

    @Override
    public void deleteCitiesEntity(Integer id) {
        CityEntity cityEntity = em.find(CityEntity.class, id);
        if (cityEntity != null) {
            em.remove(cityEntity);
        }
    }

    @Override
    public List<CityStatistics> cityQueryList() {
        Query query = em.createNamedQuery("citiesQueryDsc");
        List<Object[]> rows = query.getResultList();
        List<CityStatistics> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            CityStatistics cityStatistics =new CityStatistics();
            cityStatistics.setName((row[0].toString()));
            cityStatistics.setNumber(Integer.parseInt(row[1].toString()));
            result.add(cityStatistics);
        }
        return result;
    }
}