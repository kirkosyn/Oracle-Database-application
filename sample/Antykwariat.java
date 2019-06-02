package sample;

public class Antykwariat {
    private String nr_telefonu;
    private String nazwa;
    private String strona_internetowa;
    private Integer id_antykwariatu;
    private String data_powstania;
    private Integer id_adresu;

    public Antykwariat(String nr_telefonu, String nazwa, String strona_internetowa, Integer id_antykwariatu, String data_powstania, Integer id_adresu) {
        this.nr_telefonu = nr_telefonu;
        this.nazwa = nazwa;
        this.strona_internetowa = strona_internetowa;
        this.id_antykwariatu = id_antykwariatu;
        this.data_powstania = data_powstania;
        this.id_adresu = id_adresu;
    }

    public Antykwariat() {
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getStrona_internetowa() {
        return strona_internetowa;
    }

    public void setStrona_internetowa(String strona_internetowa) {
        this.strona_internetowa = strona_internetowa;
    }

    public Integer getId_antykwariatu() {
        return id_antykwariatu;
    }

    public void setId_antykwariatu(Integer id_antykwariatu) {
        this.id_antykwariatu = id_antykwariatu;
    }

    public String getData_powstania() {
        return data_powstania;
    }

    public void setData_powstania(String data_powstania) {
        this.data_powstania = data_powstania;
    }

    public Integer getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(Integer id_adresu) {
        this.id_adresu = id_adresu;
    }

}
