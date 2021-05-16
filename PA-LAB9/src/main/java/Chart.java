import entities.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Chart {
    private String name;
    LocalDateTime creationDate;
    List<MovieEntity> orderedMovies;
    EntityManager entityManager;

    Chart(String name, EntityManager entityManager){
        this.name = name;
        this.entityManager = entityManager;
    }

    public void showCharts(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.creationDate = LocalDateTime.now();
        System.out.println("Chart ~" + this.name + "~" + " created at " + dtf.format(creationDate));
        System.out.println("ID    Title    ReleaseDate   Duration  Score");
        Query query = entityManager.createQuery("select m from MovieEntity m order by m.score desc ");
        orderedMovies = query.getResultList();
        for (MovieEntity m : orderedMovies){
            System.out.println(m);
        }
    }
}
