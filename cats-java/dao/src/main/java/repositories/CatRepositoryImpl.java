package repositories;

import models.Cat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CatRepositoryImpl {
    private EntityManager em;

    public CatRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Cat getCatById(int id) {
        return em.find(Cat.class, id);
    }

    public Cat getCatByName(String name) {
        return em.createQuery("select ct from Cat ct where ct.name = :name", Cat.class).setParameter("name", name).getSingleResult();
    }

    public int countCats() {
        Query rs = em.createNativeQuery("SELECT count(*) FROM cat");
        return Integer.parseInt(rs.getSingleResult().toString());
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