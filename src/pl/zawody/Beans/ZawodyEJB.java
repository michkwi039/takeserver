package pl.zawody.Beans;

import pl.zawody.Entities.Zawodnicy;
import pl.zawody.Entities.Zawody;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class ZawodyEJB {
    @PersistenceContext(name = "zawody")
    private EntityManager entityManager;

    public String create(Zawody zawody) {
        try {
            entityManager.persist(zawody);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String delete(Zawody zawody) {
        try {
            entityManager.remove(entityManager.contains(zawody) ? zawody : entityManager.merge(zawody));
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String update(Zawody zawody) {
        try {
            entityManager.merge(zawody);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public Zawody find(Long id) {
        return entityManager.find(Zawody.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Zawody> findAll() {
        Query query = entityManager.createQuery("select x from Zawody x");
        return query.getResultList();
    }
}
