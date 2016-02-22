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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AsusPC
 */
@Entity
@Table(name = "FIZINISASMUO")
@NamedQueries({
    @NamedQuery(name = "Fizinisasmuo.findAll", query = "SELECT f FROM Fizinisasmuo f"),
    @NamedQuery(name = "Fizinisasmuo.findByAk", query = "SELECT f FROM Fizinisasmuo f WHERE f.ak = :ak"),
    @NamedQuery(name = "Fizinisasmuo.findByVardas", query = "SELECT f FROM Fizinisasmuo f WHERE f.vardas = :vardas"),
    @NamedQuery(name = "Fizinisasmuo.findByPavarde", query = "SELECT f FROM Fizinisasmuo f WHERE f.pavarde = :pavarde")})
public class Fizinisasmuo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AK")
    private Long ak;
    @Size(max = 20)
    @Column(name = "VARDAS")
    private String vardas;
    @Size(max = 30)
    @Column(name = "PAVARDE")
    private String pavarde;
    @JoinColumn(name = "NR", referencedColumnName = "NR")
    @ManyToOne(optional = false)
    private Savininkas nr;

    public Fizinisasmuo() {
    }

    public Fizinisasmuo(Long ak) {
        this.ak = ak;
    }

    public Long getAk() {
        return ak;
    }

    public void setAk(Long ak) {
        this.ak = ak;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Savininkas getNr() {
        return nr;
    }

    public void setNr(Savininkas nr) {
        this.nr = nr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ak != null ? ak.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fizinisasmuo)) {
            return false;
        }
        Fizinisasmuo other = (Fizinisasmuo) object;
        if ((this.ak == null && other.ak != null) || (this.ak != null && !this.ak.equals(other.ak))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.entities.Fizinisasmuo[ ak=" + ak + " ]";
    }
    
}
