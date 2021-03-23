import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddCommand extends Commands{

    AddCommand(Catalog c){
        this.catalog = c;
    }

    public void itemType(String tipItem){
        BufferedReader console = new BufferedReader( new InputStreamReader( System.in ) );

        if(tipItem.equals( "movie" )){
            try {
                System.out.println("Write the movie's name");
                String name = console.readLine();
                System.out.println("Write an id");
                String id = console.readLine();
                System.out.println("Write the path");
                String location = console.readLine();
                System.out.println("Write the director's name");
                String directorName = console.readLine();
                System.out.println("Write its rating");
                float rating = Float.parseFloat(console.readLine());
                System.out.println("Write its length");
                int movieLength = Integer.parseInt(console.readLine());
                System.out.println("Write the genre");
                MovieGenre genre = Enum.valueOf(MovieGenre.class, console.readLine());

                Movie movie = new Movie(name, id, location, genre, directorName, rating, movieLength );
                catalog.add( movie );
            } catch (IOException e) {
                System.out.println("Invalid data");
                e.printStackTrace();
            }
        }
        else if(tipItem.equals( "song" )){
            try {
                System.out.println("Write the song's name");
                String name = console.readLine();
                System.out.println("Write an id");
                String id = console.readLine();
                System.out.println("Write the path");
                String location = console.readLine();
                System.out.println("Write the artist's name");
                String artistName = console.readLine();
                System.out.println("Write the genre");
                SongGenre genre = Enum.valueOf(SongGenre.class, console.readLine());

                Song song = new Song(name, id, location, artistName, genre);
                catalog.add( song );
            } catch (IOException e) {
                System.out.println("Invalid data");
                e.printStackTrace();
            }
        }
    }
}
