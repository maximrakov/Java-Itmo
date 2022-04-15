package repository;


import entity.Cat;
import entity.Catt;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@ComponentScan({"com.example.multimodule.application","repository","srvs"})
@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

}
//public class CatRepository {
//}