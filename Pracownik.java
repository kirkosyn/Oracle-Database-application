package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pracownik {
    private Integer id_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String pesel;
    private String nr_konta_bankowego;
    private String nr_telefonu;
    private Integer id_antykwariatu;
    private Integer id_adresu;

    public Pracownik(Integer id_pracownika, String imie, String nazwisko, String data_urodzenia, String pesel,
                     String nr_konta_bankowego, String nr_telefonu, Integer id_antykwariatu, Integer id_adresu) {
        this.id_pracownika = id_pracownika; //.setValue(id_pracownika);
        this.imie = imie; //.setValue(imie);
        this.nazwisko = nazwisko; //.setValue(nazwisko);
        this.data_urodzenia = data_urodzenia; //.setValue(data_urodzenia);
        this.pesel = pesel; //.setValue(pesel);
        this.nr_konta_bankowego = nr_konta_bankowego; //.setValue(nr_konta_bankowego);
        this.nr_telefonu = nr_telefonu; //.setValue(nr_telefonu);
        this.id_antykwariatu = id_antykwariatu; //.setValue(id_antykwariatu);
        this.id_adresu = id_adresu; //.setValue(id_adresu);
    }

    public Pracownik() {
    }

    public void setId_pracownika(Integer id_pracownika) {
        this.id_pracownika = id_pracownika; //setValue(id_pracownika);
    }

    public void setImie(String imie) {
        this.imie = imie; //.setValue(imie);
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko; //.setValue(nazwisko);
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia; //.setValue(data_urodzenia);
    }

    public void setPesel(String pesel) {
        this.pesel = pesel; //.setValue(pesel);
    }

    public void setNr_konta_bankowego(String nr_konta_bankowego) {
        this.nr_konta_bankowego = nr_konta_bankowego; //.setValue(nr_konta_bankowego);
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu; //.setValue(nr_telefonu);
    }

    public void setId_antykwariatu(Integer id_antykwariatu) {
        this.id_antykwariatu = id_antykwariatu; //.setValue(id_antykwariatu);
    }

    public void setId_adresu(Integer id_adresu) {
        this.id_adresu = id_adresu; //.setValue(id_adresu);
    }

    public Integer getId_pracownika() {
        return id_pracownika;//.get();
    }

    public String getImie() {
        return imie;//.get();
    }

    public String getNazwisko() {
        return nazwisko;//.get();
    }

    public String getData_urodzenia() {
        return data_urodzenia;//.get();
    }

    public String getPesel() {
        return pesel;//.get();
    }

    public String getNr_konta_bankowego() {
        return nr_konta_bankowego;//.get();
    }

    public String getNr_telefonu() {
        return nr_telefonu;//.get();
    }

    public Integer getId_antykwariatu() {
        return id_antykwariatu;//.get();
    }

    public Integer getId_adresu() {
        return id_adresu;//.get();
    }


}
