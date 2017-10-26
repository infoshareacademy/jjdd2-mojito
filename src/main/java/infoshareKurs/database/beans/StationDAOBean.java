package infoshareKurs.database.beans;

import infoshareKurs.database.StationStatistics;
import infoshareKurs.database.entities.StationEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless

public class StationDAOBean implements StationDAOBeanLocal {

    @PersistenceContext(name = "statistics")
    EntityManager em;

    @Override
    public void addStationEntity(StationEntity stationEntity) {
        em.persist(stationEntity);
        em.flush();
    }

    @Override
    public void updateStationEntity(StationEntity stationEntity) {
        em.merge(stationEntity);
    }

    @Override
    public void deleteStationEntity(Integer id) {
        StationEntity stationEntity = em.find(StationEntity.class, id);
        if (stationEntity != null) {
            em.remove(stationEntity);
        }
    }

    @Override
    public List<StationStatistics> stationQueryList() {
        Query query = em.createNamedQuery("countriesQueryDsc");
        List<Object[]> rows = query.getResultList();
        List<StationStatistics> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            StationStatistics stationStatistics = new StationStatistics();
            stationStatistics.setName((row[0].toString()));
            stationStatistics.setNumber(Integer.parseInt(row[1].toString()));
            result.add(stationStatistics);
        }
        return result;
    }
}