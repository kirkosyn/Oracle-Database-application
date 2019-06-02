package sample;

public class Adres {
    private Integer id_adresu;
    private String miasto;
    private String ulica;
    private String nr_budynku;
    private Integer nr_lokalu;
    private String kod_pocztowy;

    public Adres(Integer id_adresu, String miasto, String ulica, String nr_budynku, Integer nr_lokalu, String kod_pocztowy) {
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.nr_lokalu = nr_lokalu;
        this.kod_pocztowy = kod_pocztowy;
    }

    public Adres() {
    }

    public Integer getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(Integer id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_budynku() {
        return nr_budynku;
    }

    public void setNr_budynku(String nr_budynku) {
        this.nr_budynku = nr_budynku;
    }

    public Integer getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(Integer nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
}
