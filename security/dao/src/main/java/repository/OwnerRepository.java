package repository;

import entity.Cat;
import entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    public Owner findByName(String name);
}
