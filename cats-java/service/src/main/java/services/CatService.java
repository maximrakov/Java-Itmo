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

    public int getAmount() {
        return catRepository.countCats();
    }
    public Cat save(Cat cat) {
        cat.setCatId(getAmount());
        Cat finallyCat = catRepository.saveCat(cat);
        return finallyCat;
    }

    public void addFriend(Cat cat, Cat hisFriend){
        catRepository.addFriend(cat, hisFriend);
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
