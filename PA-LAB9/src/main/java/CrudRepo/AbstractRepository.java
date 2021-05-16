package CrudRepo;

import entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractRepository extends CrudRepository<MovieEntity, Long> {
}
