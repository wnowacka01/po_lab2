package wyszukiwarka.Config;

import javax.persistence.Column;

public class Przejazd {
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "numerPociagu")
    private int numerPociagu;
    @Column(name = "stacjaPoczatkowa")
    private String stacjaPoczatkowa;
    @Column(name = "stacjaKoncowa")
    private String stacjaKoncowa;
    @Column(name = "dataOdjazdu")
    private String dataOdjazdu;
    @Column(name = "godzinaOdjazdu")
    private String godzinaOdjazdu;

    public Przejazd() {
    } //mapowanie danych

    public Przejazd(String nazwa, int numerPociagu, String stacjaPoczatkowa, String stacjaKoncowa, String dataOdjazdu) {
        this.nazwa = nazwa;
        this.numerPociagu = numerPociagu;
        this.stacjaPoczatkowa = stacjaPoczatkowa;
        this.stacjaKoncowa = stacjaKoncowa;
        this.dataOdjazdu = dataOdjazdu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNumerPociagu() {
        return numerPociagu;
    }

    public void setNumerPociagu(int numerPociagu) {
        this.numerPociagu = numerPociagu;
    }

    public String getStacjaPoczatkowa() {
        return stacjaPoczatkowa;
    }

    public void setStacjaPoczatkowa(String stacjaPoczatkowa) {
        this.stacjaPoczatkowa = stacjaPoczatkowa;
    }

    public String getStacjaKoncowa() {
        return stacjaKoncowa;
    }

    public void setStacjaKoncowa(String stacjaKoncowa) {
        this.stacjaKoncowa = stacjaKoncowa;
    }

    public String getDataOdjazdu() {
        return dataOdjazdu;
    }

    public void setDataOdjazdu(String dataOdjazdu) {
        this.dataOdjazdu = dataOdjazdu;
    }

    public String getGodzinaOdjazdu() {
        return godzinaOdjazdu;
    }

    public void setGodzinaOdjazdu(String godzinaOdjazdu) {
        this.godzinaOdjazdu = godzinaOdjazdu;
    }
}