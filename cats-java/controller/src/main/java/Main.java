import models.Cat;
import models.Owner;
import services.CatService;
import services.OwnerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CatService catService = new CatService(entityManager);
        OwnerService ownerService = new OwnerService(entityManager);
        Owner owner = new Owner();
        ownerService.saveOwner(owner);
        Cat cat = new Cat();
        catService.save(cat);
        owner.getCats().add(cat);
        ownerService.makeCat(owner, cat);
        Cat anotherCat = new Cat();
        catService.save(anotherCat);
        catService.makeFriendship(cat, anotherCat);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}