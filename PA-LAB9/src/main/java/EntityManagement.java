import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagement {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory create(){
        if(getEntityManagerFactory() == null){
            try{
                System.out.println("Checking entity...");
                entityManagerFactory = Persistence.createEntityManagerFactory("default");
                System.out.println("EntityManagerFactory " + getEntityManagerFactory().toString() + " created.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Entity is null");
        }
        return getEntityManagerFactory();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
