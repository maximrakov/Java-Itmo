package srvs;

import entity.Cat;
import entity.Catt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.CatRepository;

@Service
//@EnableConfigurationProperties(ServiceProperties.class)
@ComponentScan("repository")
public class CatSrvrs {

    private CatRepository ctRepository;
    @Autowired
    public CatSrvrs(CatRepository ctRepository) {
        this.ctRepository = ctRepository;
    }

    public CatRepository getCatRepository() {
        return ctRepository;
    }

    public void setCtRepository(CatRepository ctRepository) {
        this.ctRepository = ctRepository;
    }

    //    public CatRepository getCatRepository() {
//        return catRepository;
//    }

//    public void setCatRepository(CatRepository catRepository) {
//        this.catRepository = catRepository;
//    }

    public void saveCat(Cat cat) {
        ctRepository.save(cat);
    }
    public Cat FindById(int id){
        return ctRepository.findById(id).orElse(new Cat());
    }
}
