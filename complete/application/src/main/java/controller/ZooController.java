package controller;

import entity.Cat;
import entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import srvs.CatSrvrs;
import srvs.OwnerSrvrs;

@RestController
public class ZooController {
    private final CatSrvrs catSrvrs;
    private final OwnerSrvrs ownerSrvrs;
    @Autowired
    public ZooController(CatSrvrs catSrvrs, OwnerSrvrs ownerSrvrs) {
        this.catSrvrs = catSrvrs;
        this.ownerSrvrs = ownerSrvrs;
    }
    @GetMapping("/cat/{id}")
    public Cat getCat(@PathVariable String id) {
        return catSrvrs.FindById(Integer.parseInt(id));
    }

    @GetMapping("/owner/{id}")
    public Owner getOwner(@PathVariable String id) {
        return ownerSrvrs.FindById(Integer.parseInt(id));
    }


}
