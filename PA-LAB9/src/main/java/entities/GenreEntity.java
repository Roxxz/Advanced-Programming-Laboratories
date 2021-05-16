package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GENRE", schema = "ROXANA")
@NamedQuery(name="FindingGenresByNamePattern", query="SELECT m FROM GenreEntity m where m.genrename =: name")
public class GenreEntity {
    private long genreid;
    private String genrename;

    @Id
    @Column(name = "GENREID")
    public long getGenreid() {
        return genreid;
    }

    public void setGenreid(long genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "GENRENAME")
    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return genreid == that.genreid && Objects.equals(genrename, that.genrename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreid, genrename);
    }

    @Override
    public String toString() {
        return "GenreEntity with properties:" +
                "\ngenreid= " + genreid +
                ", genrename= " + genrename;
    }
}
