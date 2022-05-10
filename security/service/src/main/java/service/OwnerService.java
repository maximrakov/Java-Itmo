package service;

import entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.OwnerRepository;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
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

    public Owner findByName(String name) {
        return ownerRepository.findByName(name);
    }

}
