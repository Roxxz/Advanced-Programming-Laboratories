package lab11;

import lab11.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonDAO personDAO;

    @Autowired
    public PersonController(){
        this.personDAO = new PersonDAO();
    }

    @GetMapping
    public List<Person> getPeople() {
        return personDAO.getPeople();
    }

    @GetMapping("/count")
    public int countPeople() {
        return personDAO.getPeople().size();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
              return personDAO.getPerson(id).orElseThrow(() -> new NotFoundException("Person with id = " + id + "not found."));
    }

    @PostMapping("/add/{id}/{name}")
    public void addPerson(@PathVariable("id") int id, @PathVariable("name") String name){
        personDAO.addPerson(id, name);
    }

    @PutMapping("/modify/{id}/{name}")
    public void modifyPerson(@PathVariable("id") int id, @PathVariable("name") String name){
        personDAO.modifyPerson(id, name);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deletePerson(@PathVariable("id") int id){
        personDAO.deletePerson(id);
    }

    @GetMapping("/hello")
    public String Hello() {
        return "hiii";
    }
}
