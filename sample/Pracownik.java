package sample;

import java.util.Date;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String pesel;
    private String umowa;
    private String nr_konta_bankowego;
    private String nr_telefonu;
    private int id_antykwariatu;

    public Pracownik() {
    }

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

    public void setUmowa(String umowa) {
        this.umowa = umowa;
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

    private int id_adresu;

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

    public String getUmowa() {
        return umowa;
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
}
