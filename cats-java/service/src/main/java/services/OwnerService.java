package services;

import models.Cat;
import models.Owner;
import repositories.CatRepositoryImpl;
import repositories.OwnerRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OwnerService {
    private OwnerRepositoryImpl ownerRepository;
    private EntityManager entityManager;

    public OwnerService(EntityManager srcentityManager) {
        entityManager = srcentityManager;
        ownerRepository = new OwnerRepositoryImpl(entityManager);
    }

    public int getAmount() {
        return ownerRepository.countOwners();
    }
    public Owner getOwnerById(int id) {
        return ownerRepository.getOwnerById(id);
    }

    public Owner saveOwner(Owner owner) {
        owner.setOwnerId(getAmount());
        return ownerRepository.saveOwner(owner);
    }

    public void deleteOwner(Owner owner) {
        ownerRepository.deleteOwner(owner);
    }

    public void makeCat(Owner owner, Cat cat) {
        ownerRepository.makeCat(owner, cat);
    }
}
