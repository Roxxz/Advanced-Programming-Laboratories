import CrudRepo.AbstractRepository;
import entities.GenreEntity;
import entities.MovieEntity;
import repositories.GenreRepository;
import repositories.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        MovieEntity movieEntity1 = new MovieEntity();
        movieEntity1.setMovieid(3);
        movieEntity1.setTitle("Enola Holmes");
        movieEntity1.setReleasedate(2020);
        movieEntity1.setMovieduration(120);
        movieEntity1.setScore(9);

        MovieEntity movieEntity2 = new MovieEntity();
        movieEntity2.setMovieid(23);
        movieEntity2.setTitle("Cinderella");
        movieEntity2.setReleasedate(1990);
        movieEntity2.setMovieduration(60);
        movieEntity2.setScore(7);

        GenreEntity genreEntity1 = new GenreEntity();
        genreEntity1.setGenreid(4);
        genreEntity1.setGenrename("Romance");

        GenreEntity genreEntity2 = new GenreEntity();
        genreEntity2.setGenreid(10);
        genreEntity2.setGenrename("Anime");

        EntityManagerFactory entityManagerFactory = EntityManagement.create();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        MovieRepository movieRepository = new MovieRepository(entityManager);
//        movieRepository.create(movieEntity1);
//        movieRepository.create(movieEntity2);
        System.out.println( "Found movie by id\n" + movieRepository.findByID(78).toString());
        System.out.println( "Found movie by name\n" + movieRepository.findByName("American Crime Story").toString());

        GenreRepository genreRepository = new GenreRepository(entityManager);
//        genreRepository.create(genreEntity1);
//        genreRepository.create(genreEntity2);
        System.out.println("Found genre by id\n" + genreRepository.findByID(35).toString());
        System.out.println("Found genre by name\n" + genreRepository.findByName("Horror").toString());

        Chart chart = new Chart("Top Rated Movies", entityManager);
        chart.showCharts();

        entityManager.close();
        entityManagerFactory.close();
    }
}
