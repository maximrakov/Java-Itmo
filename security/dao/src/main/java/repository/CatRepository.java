package repository;


import entity.Cat;
import enumeration.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findAllByColor(Color color);
    Cat findByName(String name);
//    List<Cat> findAll
}