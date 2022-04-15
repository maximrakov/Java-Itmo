package srvs;

import entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.OwnerRepository;

@Service
//@EnableConfigurationProperties(ServiceProperties.class)
@ComponentScan("repository")
public class OwnerSrvrs {
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerSrvrs(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    public Owner FindById(int id) {
        return ownerRepository.findById(id).orElse(new Owner());
    }
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

}
