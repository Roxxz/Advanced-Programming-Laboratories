package lab11;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class RelationshipRepo {
    private final List<Relationship> relationships = new ArrayList<>();
    private final MultiValuedMap<Integer, Integer> relationshipMap = new HashSetValuedHashMap<>();
    Connection conn;

    public RelationshipRepo(){
        this.conn = Database.getConnection();
    }

    public void addRelationship(int id1, int id2) {

        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeUpdate(String.format("INSERT INTO RELATIONSHIPS (id1, id2) VALUES (%d, %d)", id1, id2));
            myStatement.executeUpdate(String.format("INSERT INTO RELATIONSHIPS (id1, id2) VALUES (%d, %d)", id2, id1));
            relationships.add(new Relationship(id1, id2));
            relationships.add(new Relationship(id2, id1));
            insertRelationship(id1, id2);
        } catch (Exception e) {
            System.out.println("Trying to insert duplicate data");
        }
    }

    private void insertRelationship(int id1, int id2) {
        boolean isKeyPresent = relationshipMap.containsKey(id1);
        if(!isKeyPresent){
                relationshipMap.put(id1, id2);
                relationshipMap.put(id2, id1);
        }
    }

    public List<Relationship> getAllRelationships() {
        List<Relationship> relationshipList = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM RELATIONSHIPS";
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                Relationship relationship = new Relationship(rst.getInt("id1"), rst.getInt("id2"));
                relationshipList.add(relationship);
                insertRelationship(rst.getInt("id1"), rst.getInt("id2"));
            }
        } catch (Exception e) {
            System.out.println("Error at retrieving data");
        }
        return relationshipList;
    }

    /* salvez pentru fiecare id, numarul de aparitii -> relationship number */
    private Map<Integer, Long> getOccurrences(){
        Map<Integer, Long> occurrences =
                relationshipMap.values().stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        return occurrences;
    }

    /*
   gasesc in mapa, cheia cu valoarea cea mai mare, o salvez in lista de mostConnectedPeople
   si il sterg pentru a nu mi aparea la urmatoarea iteratie, pana gasesc cei k most connected
     */
    public List<Integer> mostConnectedPeople(int k) {
        List<Integer> mostConnectedPeople = new ArrayList<>();
        Map<Integer, Long> occurrencesMap = getOccurrences();
        while(k>0) {
            int maxEntry = Collections.max(occurrencesMap.entrySet(), (entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue())).getKey();
            mostConnectedPeople.add(maxEntry);
            occurrencesMap.remove(maxEntry);
            k--;
        }
        return mostConnectedPeople;
    }

    public List<Integer> leastConnectedPeople(int k) {
        List<Integer> leastConnectedPeople = new ArrayList<>();
        Map<Integer, Long> occurrencesMap = getOccurrences();
        while(k>0) {
            int minEntry = Collections.min(occurrencesMap.entrySet(), (entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue())).getKey();
            leastConnectedPeople.add(minEntry);
            occurrencesMap.remove(minEntry);
            k--;
        }
        return leastConnectedPeople;
    }
}
