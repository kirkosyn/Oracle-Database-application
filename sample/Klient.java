package sample;

import java.util.Date;

public class Klient {
    private int id_klienta;
    private String imie;
    private String nazwisko;
    private Date data_rejestracji;
    private char czy_zarejestrowany;
    private String email;
    private String nr_telefonu;
    private int id_adresu;

    public Klient() {
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setData_rejestracji(Date data_rejestracji) {
        this.data_rejestracji = data_rejestracji;
    }

    public void setCzy_zarejestrowany(char czy_zarejestrowany) {
        this.czy_zarejestrowany = czy_zarejestrowany;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Date getData_rejestracji() {
        return data_rejestracji;
    }

    public char getCzy_zarejestrowany() {
        return czy_zarejestrowany;
    }

    public String getEmail() {
        return email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public int getId_adresu() {
        return id_adresu;
    }
}
