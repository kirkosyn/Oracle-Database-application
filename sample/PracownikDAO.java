package sample;

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

    public Pracownik SearchPracownik(Connection conn, String nazwisko) throws SQLException {
        String cmd = "SELECT * FROM PRACOWNICY WHERE NAZWISKO=" + nazwisko;
        try {

            ResultSet rs = DatabaseConnect.ExecuteStatement(cmd);
            Pracownik pracownik = getPracownikFromDatabase(rs);

            rs.close();
            return pracownik;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return new Pracownik();
    }

    private Pracownik getPracownikFromDatabase(ResultSet rs) throws SQLException {
        Pracownik pracownik = null;
        if (rs.next()) {
            pracownik = new Pracownik();
            pracownik.setId_pracownika(rs.getInt(0));
            pracownik.setImie(rs.getString(1));
            pracownik.setNazwisko(rs.getString(2));
            pracownik.setData_urodzenia(rs.getString(3));
            pracownik.setPesel(rs.getString(4));
            pracownik.setNr_konta_bankowego(rs.getString(5));
            pracownik.setNr_telefonu(rs.getString(6));
            pracownik.setId_antykwariatu(rs.getInt(7));
            pracownik.setId_adresu(rs.getInt(8));
        }
        return pracownik;
    }

    public void InsertPracownik(Connection conn, String imie, String nazwisko, Date data_urodzin, String pesel,
                                String telefon, String bank) throws SQLException {
        String cmd =
                "BEGIN\n" +
                        "INSERT INTO PRACOWNICY\n" +
                        "(ID_PRACOWNIKA, IMIE, NAZWISKO, DATA_URODZENIA, PESEL, NR_KONTA_BANKOWEGO, NR_TELEFONU, ID_ANTYKWARIATU, " +
                        "ID_ADRESU)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '" + imie + "', '" + nazwisko + "','" + data_urodzin + "','" + pesel +
                        "','" + bank + "','" + telefon + "', 1, 1);\n" +
                        "END;";

        try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void UpdatePracownik(Connection conn, int id, String nazwisko, String telefon, String bank) throws SQLException {
        String cmd =
                "BEGIN\n" +
                        "   UPDATE PRACOWNICY\n" +
                        "      SET NAZWISKO = '" + nazwisko + "'\n" +
                        "   AND NR_TELEFONU = '" + telefon + "'\n" +
                        "   AND NR_KONTA_BANKOWEGO = '" + bank + "'\n" +
                        "    WHERE ID_PRACOWNIKA = " + id + ";\n" +
                        "END;";

        try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public void DeletePracownik(Connection conn, int id) throws SQLException
    {
        String cmd =
                "BEGIN\n" +
                        "   DELETE FROM PRACOWNICY\n" +
                        "         WHERE ID_PRACOWNIKA ="+ id +";\n" +
                        "END;";

        try {
            DatabaseConnect.ExecuteUpdateStatement(cmd);
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }
}
