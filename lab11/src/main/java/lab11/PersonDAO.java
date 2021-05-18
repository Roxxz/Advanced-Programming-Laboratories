package lab11;

import org.springframework.stereotype.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class PersonDAO {
    private List<Person> people = new ArrayList<>();
    static boolean modified = false;
    Connection conn;

    PersonDAO(){
        this.conn = Database.getConnection();
    }

    public void addPerson(int id, String name){
        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeUpdate(String.format("INSERT INTO PERSON (ID, NAME) VALUES (%d, '%s')", id, name));
            people.add(new Person(id, name));
        } catch ( SQLException ex){
            System.out.println("Duplicate data - not inserted");
        }
    }

    public List<Person> getPeople() {
        if(people.isEmpty() || modified) {
            if(modified){
                people.clear();
            }
            try {
                Statement stm = conn.createStatement();
                String sql = "SELECT * FROM PERSON";
                ResultSet rst = stm.executeQuery(sql);
                while (rst.next()) {
                    Person person = new Person(rst.getInt("id"), rst.getString("name"));
                    people.add(person);
                }
            } catch (Exception e) {
                System.out.println("Error at retrieving data");
            }
        }
        return people;
    }

    public Optional<Person> getPerson(int id) {
        if (Objects.equals(id, "0")) {
            return Optional.empty();}
        else{
                return people.stream()
                        .filter(p -> p.getId() == id).findFirst();
            }
    }

    public void modifyPerson(int id, String name) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE PERSON SET name = ? WHERE ID = ?");
            myStmt.setString(1, name);
            myStmt.setInt(2, id);
            myStmt.executeUpdate();
            modified = true;
        } catch (Exception e) {
            System.out.println("Error at modifying data");
        }
    }

    public void deletePerson(int id) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("DELETE PERSON WHERE ID = ?");
            myStmt.setInt(1, id);
            myStmt.executeUpdate();
            people.remove(
                    people.stream()
                            .filter(p -> p.getId() == id).findFirst()
            );
        } catch (Exception e) {
            System.out.println("Error at deleting data");
        }
    }
}
