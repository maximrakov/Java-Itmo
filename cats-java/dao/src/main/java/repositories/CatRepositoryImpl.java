package repositories;

import models.Cat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CatRepositoryImpl {
    private EntityManager em;

    public CatRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Cat getCatById(int id) {
        return em.find(Cat.class, id);
    }

    public Cat saveCat(Cat cat) {
        em.persist(cat);

        return cat;
    }

    public void deleteCat(Cat cat) {
        em.remove(cat);
    }

    public void addFriend(Cat cat, Cat hisFriend) {
        cat.getFriends().add(hisFriend);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
