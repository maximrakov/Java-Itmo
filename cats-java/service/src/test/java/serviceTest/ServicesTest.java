package serviceTest;

import models.Cat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.CatRepositoryImpl;
import services.CatService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


public class ServicesTest {
    @Mock
    public CatRepositoryImpl catRepository;

    EntityManager entityManager;
    public CatService catService;

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        catRepository = new CatRepositoryImpl(entityManager);
        this.catService = new CatService(catRepository);
    }

    @Test
    public void checkGettingById() throws Exception {
        Cat cat = new Cat();
        cat.setName("Ivan");
        CatRepositoryImpl mock = org.mockito.Mockito.mock(CatRepositoryImpl.class);
        mock.setEm(entityManager);
        catService.setCatRepository(mock);
        when(mock.getCatById(0)).thenReturn(cat);
        catService.save(cat);
        assertThat(cat.equals(mock.getCatById(0))).isTrue();
    }
}
