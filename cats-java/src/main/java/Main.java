import models.Cat;
import models.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Cat cat = new Cat();
        Owner owner = new Owner();
        cat.setCatId(1);
        cat.setName("rr");
        Cat anotherCat = new Cat();
        anotherCat.setCatId(2);
        anotherCat.setName("pp");
        cat.setFriends(new ArrayList<>());
        cat.getFriends().add(anotherCat);
        owner.setCats(new ArrayList<>());
        owner.getCats().add(cat);
        entityManager.persist(cat);
        entityManager.persist(owner);
        entityManager.persist(anotherCat);
        entityManager.getTransaction().commit();
        Cat ct = entityManager.find(Cat.class, 1);
        entityManager.close();
    }
}
