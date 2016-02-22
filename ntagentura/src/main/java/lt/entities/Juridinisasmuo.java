/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AsusPC
 */
@Entity
@Table(name = "JURIDINISASMUO")
@NamedQueries({
    @NamedQuery(name = "Juridinisasmuo.findAll", query = "SELECT j FROM Juridinisasmuo j"),
    @NamedQuery(name = "Juridinisasmuo.findByNr", query = "SELECT j FROM Juridinisasmuo j WHERE j.nr = :nr"),
    @NamedQuery(name = "Juridinisasmuo.findByKodas", query = "SELECT j FROM Juridinisasmuo j WHERE j.kodas = :kodas"),
    @NamedQuery(name = "Juridinisasmuo.findByTipas", query = "SELECT j FROM Juridinisasmuo j WHERE j.tipas = :tipas"),
    @NamedQuery(name = "Juridinisasmuo.findByPavadinimas", query = "SELECT j FROM Juridinisasmuo j WHERE j.pavadinimas = :pavadinimas")})
public class Juridinisasmuo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR")
    private Integer nr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KODAS")
    private int kodas;
    @Size(max = 10)
    @Column(name = "TIPAS")
    private String tipas;
    @Size(max = 30)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @JoinColumn(name = "NR", referencedColumnName = "NR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Savininkas savininkas;

    public Juridinisasmuo() {
    }

    public Juridinisasmuo(Integer nr) {
        this.nr = nr;
    }

    public Juridinisasmuo(Integer nr, int kodas) {
        this.nr = nr;
        this.kodas = kodas;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Savininkas getSavininkas() {
        return savininkas;
    }

    public void setSavininkas(Savininkas savininkas) {
        this.savininkas = savininkas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.kodas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Juridinisasmuo other = (Juridinisasmuo) obj;
        if (this.kodas != other.kodas) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "lt.entities.Juridinisasmuo[ nr=" + nr + " ]";
    }
    
}
