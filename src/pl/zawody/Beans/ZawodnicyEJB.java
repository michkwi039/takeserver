package pl.zawody.Beans;


import pl.zawody.Entities.Zawodnicy;
import pl.zawody.Utility.Constants;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ZawodnicyEJB {
    @PersistenceContext(name = "zawodnicy")
    private EntityManager entityManager;

    public String create(Zawodnicy zawodnicy) {
        try {
            entityManager.persist(zawodnicy);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String delete(Zawodnicy zawodnicy) {
        try {
            entityManager.remove(entityManager.contains(zawodnicy) ? zawodnicy : entityManager.merge(zawodnicy));
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public String update(Zawodnicy zawodnicy) {
        try {
            entityManager.merge(zawodnicy);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }

    public Zawodnicy find(Long id) {
        return entityManager.find(Zawodnicy.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Zawodnicy> findAll() {
        Query query = entityManager.createQuery("select x from Zawodnicy x");
        return query.getResultList();
    }
}
