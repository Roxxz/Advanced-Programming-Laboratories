package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOVIE", schema = "ROXANA")
@NamedQuery(name="FindingMoviesByNamePattern", query="SELECT m FROM MovieEntity m where m.title = :namePattern")
public class MovieEntity {
    private long movieid;
    private String title;
    private long releasedate;
    private long movieduration;
    private long score;

    @Id
    @Column(name = "MOVIEID")
    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "RELEASEDATE")
    public long getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(long releasedate) {
        this.releasedate = releasedate;
    }

    @Basic
    @Column(name = "MOVIEDURATION")
    public long getMovieduration() {
        return movieduration;
    }

    public void setMovieduration(long movieduration) {
        this.movieduration = movieduration;
    }

    @Basic
    @Column(name = "SCORE")
    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return movieid == that.movieid && releasedate == that.releasedate && movieduration == that.movieduration && score == that.score && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, title, releasedate, movieduration, score);
    }

    @Override
    public String toString() {
        return movieid +
                " " + title +
                " " + releasedate +
                " " + movieduration +
                " " + score;
    }
}
