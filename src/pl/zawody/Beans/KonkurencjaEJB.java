package pl.zawody.Beans;




import pl.zawody.Entities.Konkurencja;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class KonkurencjaEJB {
    @PersistenceContext(name = "konkurencja")
    private EntityManager entityManager;

    public String create(Konkurencja konkurencja) {
        try {
            entityManager.persist(konkurencja);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String delete(Konkurencja konkurencja) {
        try {
            entityManager.remove(entityManager.contains(konkurencja) ? konkurencja : entityManager.merge(konkurencja));
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String update(Konkurencja konkurencja) {
        try {
            entityManager.merge(konkurencja);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public Konkurencja find(int id) {
        return entityManager.find(Konkurencja.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Konkurencja> findAll() {
        Query query = entityManager.createQuery("select x from Konkurencja x");
        return query.getResultList();
    }}
