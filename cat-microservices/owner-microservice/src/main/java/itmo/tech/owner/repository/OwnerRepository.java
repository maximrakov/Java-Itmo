package itmo.tech.owner.repository;


import itmo.tech.main.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    public Owner findByName(String name);
}
