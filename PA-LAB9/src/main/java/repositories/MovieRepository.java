package repositories;

import entities.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MovieRepository {
    public EntityManager entityManager;

    public MovieRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void create(MovieEntity movie){
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
    }

    public MovieEntity findByID(long id){
        Query query = entityManager.createQuery("select m from MovieEntity m where m.movieid=:id");
        MovieEntity movie = (MovieEntity) query.setParameter("id", id).getSingleResult();
        return movie;
    }

    public List<MovieEntity> findByName(String name){
        List<MovieEntity> moviesFoundByName = entityManager.createNamedQuery("FindingMoviesByNamePattern").setParameter("namePattern", name).getResultList();
        return moviesFoundByName;
    }
}
