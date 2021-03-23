import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            out.writeObject(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog c = new Catalog();
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            c = (Catalog) in.readObject();
            if (c == null || c.getItems().isEmpty()) {
                throw new InvalidCatalogException("Empty object");
            }
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            System.out.println("Class not found!");
            e1.printStackTrace();
        }
        return c;
    }

    public static void play(Item it) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(it.getLocation());
        try {
            if (file.isFile())
                desktop.open(file);
            else
                desktop.browse(new URI( it.getLocation() ));
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file " + file);
            e.printStackTrace();
        } catch (URISyntaxException e1) {
            System.out.println("Given URI syntax is wrong!");
            e1.printStackTrace();
        }
    }
}
