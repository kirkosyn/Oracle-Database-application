package sample;

import com.sun.istack.internal.NotNull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class PracownikDAO {

    private ObservableList<Pracownik> pracownicy;
    /*public void showParameters(Pracownik pracownik)
    {
        System.out.println(String.valueOf(pracownik.getId_pracownika() + " " + pracownik.getImie() + " " +
                pracownik.getNazwisko() + " " + String.valueOf(pracownik.getData_urodzenia()) + " " +
                pracownik.getPesel() + " " + pracownik.getNr_konta_bankowego() + " " +
                pracownik.getNr_telefonu() + " " + String.valueOf(pracownik.getId_antykwariatu()) + " " +
                String.valueOf(pracownik.getId_adresu())));
    }*/

    public PracownikDAO() {
    }

    public ObservableList<Pracownik> GetAllPracownicy() {
        pracownicy = FXCollections.observableArrayList();
        Pracownik pracownik;
        try {
            String cmd = "SELECT * FROM PRACOWNICY";
            ResultSet rs = DatabaseConnect.ExecuteStatement(cmd);
            while (rs.next()) {
                pracownik = new Pracownik();

                pracownik.setId_pracownika(rs.getInt(1));
                pracownik.setImie(rs.getString(2));
                pracownik.setNazwisko(rs.getString(3));
                pracownik.setData_urodzenia(rs.getDate(4).toString());
                pracownik.setPesel(rs.getString(5));
                pracownik.setNr_konta_bankowego(rs.getString(6));
                pracownik.setNr_telefonu(rs.getString(7));
                pracownik.setId_antykwariatu(rs.getInt(8));
                pracownik.setId_adresu(rs.getInt(9));

                //showParameters(pracownik);

                pracownicy.add(pracownik);
            }

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.toString());
            alert.show();
        }

        return pracownicy;
    }

    public ObservableList<Pracownik> SearchPracownik(String nazwisko) throws SQLException {
        if (nazwisko.isEmpty())
            return GetAllPracownicy();

        nazwisko = nazwisko.toLowerCase();
        nazwisko = nazwisko.substring(0, 1).toUpperCase() + nazwisko.substring(1);
        ObservableList<Pracownik> pracownicy = null;

        String cmd = "SELECT * FROM PRACOWNICY WHERE NAZWISKO LIKE \'" + nazwisko + "\'";
        try {

            ResultSet rs = DatabaseConnect.ExecuteStatement(cmd);
            pracownicy = getPracownikFromDatabase(rs);

            rs.close();
            return pracownicy;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pracownicy;
    }

    private ObservableList<Pracownik> getPracownikFromDatabase(@NotNull ResultSet rs) throws SQLException {
        Pracownik pracownik;
        ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();

        while (rs.next()) {
            pracownik = new Pracownik();
            pracownik.setId_pracownika(rs.getInt(1));
            pracownik.setImie(rs.getString(2));
            pracownik.setNazwisko(rs.getString(3));
            pracownik.setData_urodzenia(rs.getString(4));
            pracownik.setPesel(rs.getString(5));
            pracownik.setNr_konta_bankowego(rs.getString(6));
            pracownik.setNr_telefonu(rs.getString(7));
            pracownik.setId_antykwariatu(rs.getInt(8));
            pracownik.setId_adresu(rs.getInt(9));

            pracownicy.add(pracownik);
        }
        return pracownicy;
    }

    public String InsertPracownik(String imie, String nazwisko, Date data_urodzin, String pesel,
                                String telefon, String bank) throws SQLException {
        String cmd = "INSERT INTO PRACOWNICY\n" +
                "VALUES\n" +
                "(id_seq.nextval, '" + imie + "', '" + nazwisko + "', DATE '" + data_urodzin + "','" + pesel +
                "','" + bank + "','" + telefon + "', 1, 1)";

        return cmd;
        /*try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }*/
    }

    public void UpdatePracownik(int id, String nazwisko, String telefon, String bank) throws SQLException {
        String cmd = "UPDATE PRACOWNICY\n" +
                "      SET NAZWISKO = '" + nazwisko + "'\n" +
                "   AND NR_TELEFONU = '" + telefon + "'\n" +
                "   AND NR_KONTA_BANKOWEGO = '" + bank + "'\n" +
                "    WHERE ID_PRACOWNIKA = " + id;
        try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void DeletePracownik(int id) throws SQLException {
        String cmd = "DELETE FROM PRACOWNICY " +
                "WHERE ID_PRACOWNIKA = " + id;
        try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }
}
