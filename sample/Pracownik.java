package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String pesel;
    private String nr_konta_bankowego;
    private String nr_telefonu;
    private int id_antykwariatu;
    private int id_adresu;
    ObservableList<Pracownik> pracownicy;

    public Pracownik(int id_pracownika, String imie, String nazwisko, Date data_urodzenia, String pesel,
                     String nr_konta_bankowego, String nr_telefonu, int id_antykwariatu, int id_adresu) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.nr_konta_bankowego = nr_konta_bankowego;
        this.nr_telefonu = nr_telefonu;
        this.id_antykwariatu = id_antykwariatu;
        this.id_adresu = id_adresu;
    }

    public Pracownik(){}

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setNr_konta_bankowego(String nr_konta_bankowego) {
        this.nr_konta_bankowego = nr_konta_bankowego;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public void setId_antykwariatu(int id_antykwariatu) {
        this.id_antykwariatu = id_antykwariatu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNr_konta_bankowego() {
        return nr_konta_bankowego;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public int getId_antykwariatu() {
        return id_antykwariatu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void showParameters(Pracownik pracownik)
    {
        System.out.println(String.valueOf(pracownik.getId_pracownika() + " " + pracownik.getImie() + " " +
                pracownik.getNazwisko() + " " + String.valueOf(pracownik.getData_urodzenia()) + " " +
                pracownik.getPesel() + " " + pracownik.getNr_konta_bankowego() + " " +
                pracownik.getNr_telefonu() + " " + String.valueOf(pracownik.getId_antykwariatu()) + " " +
                String.valueOf(pracownik.getId_adresu())));
    }

    public ObservableList<Pracownik> GetAllPracownicy(Connection conn) {
        pracownicy = FXCollections.observableArrayList();
        Pracownik pracownik;
        try
        {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM PRACOWNICY");
            while(rs.next())
            {
                pracownik = new Pracownik();
                //System.out.println(rs.getInt(1));
                /*pracownicy.add(new Pracownik(rs.getInt("Id_Pracownika"), rs.getString("Imie"),
                        rs.getString("Nazwisko"), rs.getDate("Data_Urodzenia"), rs.getString("Pesel"),
                        rs.getString("Umowa"),rs.getString("Nr_Konta_Bankowego"), rs.getString("Nr_Telefonu"),
                        rs.getInt("Id_Antykwariatu"), rs.getInt("Id_Adresu")));*/

                pracownik.setId_pracownika(rs.getInt("Id_Pracownika"));
                pracownik.setImie(rs.getString("Imie"));
                pracownik.setNazwisko(rs.getString("Nazwisko"));
                pracownik.setData_urodzenia(rs.getDate("Data_Urodzenia"));
                pracownik.setPesel(rs.getString("Pesel"));
                pracownik.setNr_konta_bankowego(rs.getString("Nr_Konta_Bankowego"));
                pracownik.setNr_telefonu(rs.getString("Nr_Telefonu"));
                pracownik.setId_antykwariatu(rs.getInt("Id_Antykwariatu"));
                pracownik.setId_adresu(rs.getInt("Id_Adresu"));

                /*pracownik.setId_pracownika(rs.getInt(1));
                pracownik.setImie(rs.getString(2));
                pracownik.setNazwisko(rs.getString(3));
                pracownik.setData_urodzenia(rs.getDate(4));
                pracownik.setPesel(rs.getString(5));
                pracownik.setNr_konta_bankowego(rs.getString(6));
                pracownik.setNr_telefonu(rs.getString(7));
                pracownik.setId_antykwariatu(rs.getInt(8));
                pracownik.setId_adresu(rs.getInt(9));*/

                showParameters(pracownik);

                pracownicy.add(pracownik);
            }

            rs.close();
            state.close();
        }
        catch (SQLException ex) {
        }

        return pracownicy;
    }
}
