import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayCommand extends Commands{

    PlayCommand(Catalog c){
        this.catalog = c;
    }

    public void playItem(String item){
        BufferedReader console = new BufferedReader( new InputStreamReader( System.in ) );
        try{
            if(item.equals( "movie" )){
                System.out.println("Write the movie's id");
                String id = console.readLine();
                CatalogUtil.play( catalog.findById(id));
            }
            if(item.equals( "song" )){
                System.out.println("Write the song's id");
                String id = console.readLine();
                CatalogUtil.play( catalog.findById(id));
            }
        }catch (IOException e) {
            System.out.println("Invalid id");
            e.printStackTrace();
        }
    }
}
