package repositories;

import entities.GenreEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenreRepository {
    public EntityManager entityManager;

    public GenreRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void create(GenreEntity genre){
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
    }

    public GenreEntity findByID(long id){
        Query query = entityManager.createQuery("select g from GenreEntity g where g.genreid=:id");
        GenreEntity genre = (GenreEntity) query.setParameter("id", id).getSingleResult();
        return genre;
    }

    public List<GenreEntity> findByName(String name){
        List<GenreEntity> genresFoundByName = entityManager.createNamedQuery("FindingGenresByNamePattern").setParameter("name", name).getResultList();
        return genresFoundByName;
    }
}
