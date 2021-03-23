import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws InvalidCatalogException, IOException{
                Main app = new Main();
                app.testCreateSave();
                app.testLoadView();
                app.testCommandShell();
        }

        private void testCreateSave(){
                Catalog catalog = new Catalog("Multimedia Items", "C:\\PA\\lab5\\catalog.ser");
                Movie movie = new Movie("TheOffice","300", "C:\\Users\\YYY\\Videos\\The Office Trailer.mp4" , MovieGenre.COMEDY, "John Krasinski", 7.3f, 135 );
                Song song = new Song("Save your tears", "45", "C:\\Users\\YYY\\Videos\\Save Your Tears.mp3", "The Weeknd", SongGenre.POP);
                catalog.add(song);
                catalog.add(movie);
                catalog.list();

                CatalogUtil.save(catalog);
        }

        private void testLoadView() throws InvalidCatalogException{
                Catalog catalog = CatalogUtil.load("C:\\PA\\lab5\\catalog.ser");
                 Item item = catalog.findById("45");
                CatalogUtil.play(item);
        }

        private void testCommandShell() throws IOException{
                Catalog catalog = new Catalog("Multimedia Items", "C:\\PA\\lab5\\catalog.ser");
                String commandLine;
                BufferedReader console = new BufferedReader( new InputStreamReader( System.in ) );
                try {
                        while (true) {
                                System.out.print( "command> " );
                                commandLine = console.readLine();
                                switch (commandLine) {
                                        case "add": {
                                                System.out.println( "Ce tip de item adaugati? movie/song" );
                                                String tip = console.readLine();
                                                AddCommand add1 = new AddCommand( catalog );
                                                add1.itemType( tip );
                                                break;
                                        }
                                        case "list":
                                                ListCommand list = new ListCommand( catalog );
                                                list.listItems();
                                                break;
                                        case "play": {
                                                System.out.println( "Ce tip de item redati? movie/song" );
                                                String tip = console.readLine();
                                                PlayCommand play = new PlayCommand( catalog );
                                                play.playItem( tip );
                                                break;
                                        }
                                        case "save":
                                                SaveCommand save = new SaveCommand( catalog );
                                                save.saveItems();
                                                break;
                                        case "load":
                                                LoadCommand load = new LoadCommand( catalog );
                                                load.loadItem( catalog );
                                                break;
                                        case "X":
                                                return;
                                        default:
                                                throw new InvalidCommandException("Invalid command.");
                                }
                        }
                }catch(InvalidCommandException inv){
                        System.out.println(inv.getMessage());
                }
        }
}
