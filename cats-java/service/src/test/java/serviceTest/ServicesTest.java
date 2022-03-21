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

    @Mock
    public CatService catService;

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        catRepository = new CatRepositoryImpl(entityManager);
        this.catService = new CatService(catRepository);
    }

    @Test
    public void test() throws Exception {
        Cat cat = new Cat();
        cat.setName("Ivan");
        cat.setCatId(1);
        CatService mock = org.mockito.Mockito.mock(CatService.class);
        mock.save(cat);
        mock.getCatById(1);
        when(mock.getCatById(1)).thenReturn(new Cat());
        Cat requiredCat = catService.getCatById(1);
        assertThat(requiredCat.equals(cat)).isTrue();

    }
}
