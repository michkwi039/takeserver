package pl.zawody.Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Zawodnicy implements Serializable {
    private Integer idZawodnika;
    private String imie;
    private String nazwisko;
    private String plec;
    private Integer wiek;
    @XmlTransient
    private Collection<Wyniki> wynikisByIdZawodnika;

    @Id
    @Column(name = "idZawodnika", nullable = false)
    public Integer getIdZawodnika() {
        return idZawodnika;
    }

    public void setIdZawodnika(Integer idZawodnika) {
        this.idZawodnika = idZawodnika;
    }

    @Basic
    @Column(name = "imie", nullable = false, length = 45)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko", nullable = false, length = 45)
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "plec", nullable = false, length = 1)
    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Basic
    @Column(name = "wiek", nullable = false)
    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zawodnicy zawodnicy = (Zawodnicy) o;
        return Objects.equals(idZawodnika, zawodnicy.idZawodnika) &&
                Objects.equals(imie, zawodnicy.imie) &&
                Objects.equals(nazwisko, zawodnicy.nazwisko) &&
                Objects.equals(plec, zawodnicy.plec) &&
                Objects.equals(wiek, zawodnicy.wiek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idZawodnika, imie, nazwisko, plec, wiek);
    }

    @OneToMany(mappedBy = "zawodnicyByZawodnicyIdZawodnika")
    public Collection<Wyniki> getWynikisByIdZawodnika() {
        return wynikisByIdZawodnika;
    }

    public void setWynikisByIdZawodnika(Collection<Wyniki> wynikisByIdZawodnika) {
        this.wynikisByIdZawodnika = wynikisByIdZawodnika;
    }
}
