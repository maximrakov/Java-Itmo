package controller;

import entity.Cat;
import entity.Owner;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import security.MyUserDetailsService;
import service.CatService;
import service.OwnerService;
import service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ZooController {
    private final CatService catService;
    private final OwnerService ownerService;
    private final PersonService personService;
    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public ZooController(CatService catService, OwnerService ownerService, PersonService personService, MyUserDetailsService myUserDetailsService) {
        this.catService = catService;
        this.ownerService = ownerService;
        this.personService = personService;
        this.myUserDetailsService = myUserDetailsService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/cat/{id}")
    public Cat getCat(@PathVariable String id) {
        Owner currentOwner = getLogginedOwner();
        Cat currentCat = catService.FindById(Integer.parseInt(id));
        if(currentCat.getOwnerId() != currentOwner.getOwnerId()) {
            throw new AccessDeniedException("Cat has another owner");
        }
        return catService.FindById(Integer.parseInt(id));
    }

    @GetMapping("/cats")
    public List<Cat> getCats() {
        Owner currentOwner = getLogginedOwner();
        List<Cat> cats = catService.FindAll();
        List<Cat> OwnerCats = cats.stream().filter(cat -> (cat.getOwnerId() == currentOwner.getOwnerId())).
                collect(Collectors.toList());
        return OwnerCats;
    }

    private Boolean getName(String name) {
        return name.equals(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public Owner getLogginedOwner() {
        return personService.findByName(myUserDetailsService.
                loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                        getName()).getUsername()).getOwner();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/owner/{id}")
    public Owner getOwner(@PathVariable String id) {
        return ownerService.FindById(Integer.parseInt(id));
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/Color/{color}")
    public List<Cat> getCatByColor(@PathVariable String color) {
        Owner currentOwner = getLogginedOwner();
        List<Cat> cats = catService.FindByColor(color);
        List<Cat> OwnerCats = cats.stream().filter(cat -> (cat.getOwnerId() == currentOwner.getOwnerId())).
                collect(Collectors.toList());
        return catService.FindByColor(color);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/Name/{name}")
    public Cat getCatByName(@PathVariable String name) {
        Cat cat = catService.FindByName(name);
        if(cat.getOwnerId() != getLogginedOwner().getOwnerId()) {
            throw new AccessDeniedException("Cat has another owner");
        }
        return cat;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/createOwner")
    public void createOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        Person person = personService.findByName(myUserDetailsService.
                loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getUsername());
        person.setOwner(ownerService.findByName(owner.getName()));
        personService.save(person);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping("/createCat")
    public void createCat(@RequestBody Cat cat) {
        if(personService.findByName(myUserDetailsService.
                loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                        getName()).getUsername()).getOwner() != null) {
            cat.setOwnerId(personService.findByName(myUserDetailsService.
                    loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                            getName()).getUsername()).getOwner().getOwnerId());

            Owner currentOwner = ownerService.FindById(personService.findByName(myUserDetailsService.
                    loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().
                            getName()).getUsername()).getOwner().getOwnerId());
            catService.saveCat(cat);
            cat = catService.FindByName(cat.getName());
            currentOwner.getCats().add(cat);
            ownerService.saveOwner(currentOwner);
        }
    }
}