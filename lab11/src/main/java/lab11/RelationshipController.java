package lab11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    private final RelationshipRepo relationshipRepo;

    @Autowired
    public RelationshipController() throws SQLException {
        this.relationshipRepo = new RelationshipRepo();
    }

    @GetMapping
    public List<Relationship> getRelationships() {
        return relationshipRepo.getAllRelationships();
    }

    @GetMapping("/count")
    public int countRelationships() {
        return relationshipRepo.getAllRelationships().size();
    }

    @PostMapping("/add/{id1}/{id2}")
    public void addRelationship(@PathVariable("id1") int id1, @PathVariable("id2") int id2){
        relationshipRepo.addRelationship(id1, id2);
    }

    @GetMapping("/mostconn/{k}")
    public List<Integer> mostConnectedPeople(@PathVariable("k") int k) {
        return relationshipRepo.mostConnectedPeople(k);
    }

    @GetMapping("/leastconn/{k}")
    public List<Integer> leastConnectedPeople(@PathVariable("k") int k) {
        return relationshipRepo.leastConnectedPeople(k);
    }
}
