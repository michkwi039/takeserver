package pl.zawody.Beans;

import pl.zawody.Entities.Biegi;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BiegEJB {
    @PersistenceContext(name = "biegi")
    private EntityManager entityManager;

    public String create(Biegi bieg) {
        try {
            entityManager.persist(bieg);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String delete(Biegi bieg) {
        try {
            entityManager.remove(entityManager.contains(bieg) ? bieg : entityManager.merge(bieg));
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String update(Biegi practice) {
        try {
            entityManager.merge(practice);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public Biegi find(int id) {
        return entityManager.find(Biegi.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Biegi> findAll() {
        Query query = entityManager.createQuery("select x from Biegi x");
        return query.getResultList();
    }
}
