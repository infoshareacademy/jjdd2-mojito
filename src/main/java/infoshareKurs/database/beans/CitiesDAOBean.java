package infoshareKurs.database.beans;

import infoshareKurs.database.entities.CitiesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List<CitiesEntity> getAll() {
        Query query = em.createQuery("SELECT e FROM CitiesEntity e");
        return query.getResultList();
    }
}
