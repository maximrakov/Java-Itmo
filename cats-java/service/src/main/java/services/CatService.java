package services;

import models.Cat;
import repositories.CatRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CatService {
    private CatRepositoryImpl catRepository;
    private EntityManager entityManager;
    public CatService(EntityManager srcentityManager) {
        entityManager = srcentityManager;
        catRepository = new CatRepositoryImpl(entityManager);
    }

    public CatService(CatRepositoryImpl catRepository) {
        this.catRepository = catRepository;
    }

    public Cat getCatById(int id) {
        return catRepository.getCatById(id);
    }

    public Cat save(Cat cat) {
        Cat finallyCat = catRepository.saveCat(cat);
        // entityManager.getTransaction().commit();
//        entityManager.close();
        return  finallyCat;
    }

    public void addFriend(Cat cat, Cat hisFriend){
        catRepository.addFriend(cat, hisFriend);
//        entityManager.getTransaction().commit();
    }

    public void makeFriendship(Cat oneCat, Cat anotherCat) {
        addFriend(oneCat, anotherCat);
        addFriend(anotherCat, oneCat);
    }

    public CatRepositoryImpl getCatRepository() {
        return catRepository;
    }

    public void setCatRepository(CatRepositoryImpl catRepository) {
        this.catRepository = catRepository;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
