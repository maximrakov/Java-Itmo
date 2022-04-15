package repositories;

import models.Cat;
import models.Owner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OwnerRepositoryImpl {
    private EntityManager em;

    public OwnerRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Owner getOwnerById(int id) {
        return em.find(Owner.class, id);
    }

    public Owner saveOwner(Owner owner) {
        em.persist(owner);
        return owner;
    }

    public Owner getCatByName(String name) {
        return em.createQuery("select own from Owner own where own.name = :name", Owner.class).setParameter("name", name).getSingleResult();
    }
    public int countOwners() {
        Query rs = em.createNativeQuery("SELECT count(*) FROM owner");
        return Integer.parseInt(rs.getSingleResult().toString());
    }

    public void deleteOwner(Owner owner) {
        em.remove(owner);
    }

    public void makeCat(Owner owner, Cat cat) {
        owner.getCats().add(cat);
    }
}
