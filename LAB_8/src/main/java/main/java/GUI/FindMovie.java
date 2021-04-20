package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import main.java.Main;

public class FindMovie extends JFrame{
    JLabel lb, idLabel, titleLabel, releaseDateLabel, movieDurationLabel, movieScoreLabel, enterLabel;
    JTextField idTextField, titleTextField, releaseDateTextField, movieDurationTextField, movieScoreTextField, enterTextField;
    JButton search, findActor, findDirector, findGenre;
    JButton showMovies, deleteMovie;
    JFrame tableFrame;
    JTable table;

    FindMovie() {
        super("Fetching Movies Information");
        enterLabel = new JLabel("Enter Name:");
        enterLabel.setBounds(20, 20, 100, 30);
        enterTextField = new JTextField(20);
        enterTextField.setBounds(130, 20, 200, 30);

        search = new JButton("Search");
        search.setBounds(20, 50, 100, 30);
        search.addActionListener(e -> {
            try {
                String str = enterTextField.getText();
                Connection con = Main.getConnection();
                PreparedStatement st = con.prepareStatement("select * from movie where lower(trim(TITLE))=lower(trim(?))");
                st.setString(1, str);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    String title = rs.getString(2);
                    int date = rs.getInt(3);
                    int duration = rs.getInt(4);
                    int score = rs.getInt(5);

                    idTextField.setText(String.valueOf(id));
                    titleTextField.setText(title);
                    releaseDateTextField.setText(String.valueOf(date));
                    movieDurationTextField.setText(String.valueOf(duration));
                    movieScoreTextField.setText(String.valueOf(score));
                } else {
                    JOptionPane.showMessageDialog(null, "Name not Found");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        deleteMovie = new JButton("Delete");
        deleteMovie.setBounds(130, 50, 100, 30);
        deleteMovie.addActionListener(e -> {
            try {
                String str = enterTextField.getText();
                Connection con = Main.getConnection();
                PreparedStatement st = con.prepareStatement("delete from movie where lower(trim(TITLE))=lower(trim(?))");
                st.setString(1, str);
                st.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        showMovies = new JButton("Show Movies");
        showMovies.setBounds(240, 50, 150, 30);
        showMovies.addActionListener(e -> {
            tableFrame = new JFrame("Movies Table");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            String sql="select * from movie";
            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            ArrayList columnNames = new ArrayList();
            ArrayList data = new ArrayList();
            try (Connection connection = Main.getConnection();
                 Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery( sql ))
            {
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                for (int i = 1; i <= columns; i++)
                {
                    columnNames.add( md.getColumnName(i) );
                }
                while (rs.next())
                {
                    ArrayList row = new ArrayList(columns);
                    for (int i = 1; i <= columns; i++)
                    {
                        row.add( rs.getObject(i) );
                    }
                    data.add( row );
                }
            }
            catch (SQLException ex)
            {
                System.out.println( ex.getMessage() );
            }
            Vector columnNamesVector = new Vector();
            Vector dataVector = new Vector();
            for (Object datum : data) {
                ArrayList subArray = (ArrayList) datum;
                Vector subVector = new Vector(subArray);
                dataVector.add(subVector);
            }
            for (Object columnName : columnNames) columnNamesVector.add(columnName);

            table = new JTable(dataVector, columnNamesVector)
            {
                public Class getColumnClass(int column)
                {
                    for (int row = 0; row < getRowCount(); row++)
                    {
                        Object o = getValueAt(row, column);
                        if (o != null)
                        {
                            return o.getClass();
                        }
                    }
                    return Object.class;
                }
            };
            JScrollPane scrollPane = new JScrollPane( table );
            tableFrame.add( scrollPane );

            tableFrame.setVisible(true);
            tableFrame.setSize(500, 500);
        });

        findActor = new JButton("Click here to find an Actor");
        findActor.setBounds(20, 380, 300, 30);
        findActor.addActionListener(e -> {
            FindActor findActor = new FindActor();
        });
        findDirector = new JButton("Click here to find a director");
        findDirector.setBounds(20, 430, 300, 30);
        findDirector.addActionListener(e -> {
            FindDirector findActor = new FindDirector();
        });
        findGenre = new JButton("Click here to find a genre");
        findGenre.setBounds(20, 480, 300, 30);
        findGenre.addActionListener(e -> {
            FindGenre findGenre = new FindGenre();
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 900);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 120, 100, 30);
        idTextField = new JTextField(50);
        idTextField.setBounds(130, 120, 200, 30);

        titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 170, 100, 30);
        titleTextField = new JTextField(100);
        titleTextField.setBounds(130, 170, 200, 30);

        releaseDateLabel = new JLabel("Release Date:");
        releaseDateLabel.setBounds(20, 230, 100, 30);
        releaseDateTextField = new JTextField(50);
        releaseDateTextField.setBounds(130, 230, 200, 30);

        movieDurationLabel = new JLabel("Movie Duration:");
        movieDurationLabel.setBounds(20, 280, 100, 30);
        movieDurationTextField = new JTextField(50);
        movieDurationTextField.setBounds(130, 280, 100, 30);

        movieScoreLabel = new JLabel("Score:");
        movieScoreLabel.setBounds(20, 330, 100, 30);
        movieScoreTextField = new JTextField(50);
        movieScoreTextField.setBounds(130, 330, 100, 30);

        setLayout(null);

        add(enterLabel);
        add(enterTextField);
        add(search);
        add(deleteMovie);
        add(idLabel);
        add(idTextField);
        add(titleLabel);
        add(titleTextField);
        add(releaseDateLabel);
        add(releaseDateTextField);
        add(movieDurationLabel);
        add(movieDurationTextField);
        add(movieScoreLabel);
        add(movieScoreTextField);
        add(findActor);
        add(findDirector);
        add(findGenre);
        add(showMovies);
        //Set TextField Editable False
        idTextField.setEditable(false);
        titleTextField.setEditable(false);
        releaseDateTextField.setEditable(false);
        movieDurationTextField.setEditable(false);
        movieScoreTextField.setEditable(false);

    }

    public static void main(String[] args) throws SQLException {
        new FindMovie();
    }
}