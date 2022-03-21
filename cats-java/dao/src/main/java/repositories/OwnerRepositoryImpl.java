package repositories;

import models.Cat;
import models.Owner;

import javax.persistence.EntityManager;

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

    public void deleteOwner(Owner owner) {
        em.remove(owner);
    }

    public void makeCat(Owner owner, Cat cat) {
        owner.getCats().add(cat);
    }
}
