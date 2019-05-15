package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Observable;

public class Controller {

    static Connection conn;
    //public ObservableList<Pracownik> pracownicy;

    public Controller() {
    }

    public void Initialize() {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        try {
            conn = databaseConnect.GetConn();
            /*Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM PRACOWNICY");*/


            /*while(rs.next())
            {
                System.out.println(rs.getObject(2));
            }*/
        } catch (SQLException ex) {

        }
    }

    public ObservableList<Pracownik> GetAllPracownicy(Connection conn) {
        ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();

        try
        {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM PRACOWNICY");
            while(rs.next())
            {
                System.out.println(rs.getObject(2));
                pracownicy.add(new Pracownik(rs.getInt("Id_Pracownika"), rs.getString("Imie"),
                        rs.getString("Nazwisko"), rs.getDate("Data_Urodzenia"), rs.getString("Pesel"),
                        rs.getString("Umowa"),rs.getString("Nr_Konta_Bankowego"), rs.getString("Nr_Telefonu"),
                        rs.getInt("Id_Antykwariatu"), rs.getInt("Id_Adresu")));


            }
        }
        catch (SQLException ex) {
        }

        return pracownicy;
    }
}
