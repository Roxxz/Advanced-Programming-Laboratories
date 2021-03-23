public class Song extends Item {
    private final String artistName;
    private final SongGenre genre;

    Song(String name, String id, String location, String artistName, SongGenre genre) {
        super ( name, id, location );
        this.artistName = artistName;
        this.genre = genre;
        System.out.println("You added the " + this.genre + " song: " + this.name + "\n");
    }

    @Override
    public String toString() {
        return "\nSong{" +
                "name=" + name +
                " , id = " + id +
                ", location= " + location +
                ", Artist's name= " + artistName +
                ", genre= " + genre +
                "}\n";
    }
}