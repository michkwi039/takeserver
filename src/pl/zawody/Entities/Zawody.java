package pl.zawody.Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Zawody implements Serializable {
    private Integer idZawody;
    private Integer iloscBiegow;
    private Date data;
    @XmlTransient
    private Collection<Biegi> biegisByIdZawody;

    @Id
    @Column(name = "idZawody", nullable = false)
    public Integer getIdZawody() {
        return idZawody;
    }

    public void setIdZawody(Integer idZawody) {
        this.idZawody = idZawody;
    }

    @Basic
    @Column(name = "iloscBiegow", nullable = false)
    public Integer getIloscBiegow() {
        return iloscBiegow;
    }

    public void setIloscBiegow(Integer iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }

    @Basic
    @Column(name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zawody zawody = (Zawody) o;
        return Objects.equals(idZawody, zawody.idZawody) &&
                Objects.equals(iloscBiegow, zawody.iloscBiegow) &&
                Objects.equals(data, zawody.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idZawody, iloscBiegow, data);
    }

    @OneToMany(mappedBy = "zawodyByZawodyIdZawody")
    public Collection<Biegi> getBiegisByIdZawody() {
        return biegisByIdZawody;
    }

    public void setBiegisByIdZawody(Collection<Biegi> biegisByIdZawody) {
        this.biegisByIdZawody = biegisByIdZawody;
    }
}
