package pl.zawody.Beans;



import pl.zawody.Entities.Wyniki;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class WynikEJB {

    @PersistenceContext(name = "wyniki")
    private EntityManager entityManager;

    public String create(Wyniki wyniki) {
        try {
            entityManager.persist(wyniki);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String delete(Wyniki wyniki) {
        try {
            entityManager.remove(entityManager.contains(wyniki) ? wyniki : entityManager.merge(wyniki));
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String update(Wyniki wyniki) {
        try {
            entityManager.merge(wyniki);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public Wyniki find(int id) {
        return entityManager.find(Wyniki.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Wyniki> findAll() {
        Query query = entityManager.createQuery("select x from Wyniki x");
        return query.getResultList();
    }
}
