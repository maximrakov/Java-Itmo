import models.Cat;
import org.junit.Before;
import org.junit.Test;
import repositories.CatRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {

    public CatRepositoryImpl catRepository;

    EntityManager entityManager;

    @Before
    public void initRepo() {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        catRepository = new CatRepositoryImpl(entityManager);
    }

    @Test
    public void savingEntities() {
        Cat cat = new Cat();
        cat.setName("Ivan");
        catRepository.saveCat(cat);
        assertThat(cat.equals(catRepository.getCatByName("Ivan"))).isTrue();
    }
}