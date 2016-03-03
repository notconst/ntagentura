/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 *
 * @author AsusPC
 */
@Entity
@Table(name = "SAVININKAS")
@NamedQueries({
    @NamedQuery(name = "Savininkas.findAll", query = "SELECT s FROM Savininkas s"),
    @NamedQuery(name = "Savininkas.findByNr", query = "SELECT s FROM Savininkas s WHERE s.nr = :nr"),
    @NamedQuery(name = "Savininkas.findByTelnr", query = "SELECT s FROM Savininkas s WHERE s.telnr = :telnr")})
public class Savininkas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NR")
    private Integer nr;
    @Column(name = "TELNR")
    private BigInteger telnr;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "savininkonr")
    private List<Objektas> objektasList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nr")
    private List<Fizinisasmuo> fizinisasmuoList = new  ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "savininkas")
    private Juridinisasmuo juridinisasmuo;

    public Savininkas() {
    }

    public Savininkas(Integer nr) {
        this.nr = nr;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public BigInteger getTelnr() {
        return telnr;
    }

    public void setTelnr(BigInteger telnr) {
        this.telnr = telnr;
    }

    public List<Objektas> getObjektasList() {
        return objektasList;
    }

    public void setObjektasList(List<Objektas> objektasList) {
        this.objektasList = objektasList;
    }

    public List<Fizinisasmuo> getFizinisasmuoList() {
        return fizinisasmuoList;
    }

    public void setFizinisasmuoList(List<Fizinisasmuo> fizinisasmuoList) {
        this.fizinisasmuoList = fizinisasmuoList;
    }

    public Juridinisasmuo getJuridinisasmuo() {
        return juridinisasmuo;
    }

    public void setJuridinisasmuo(Juridinisasmuo juridinisasmuo) {
        this.juridinisasmuo = juridinisasmuo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nr != null ? nr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Savininkas)) {
            return false;
        }
        Savininkas other = (Savininkas) object;
        if ((this.nr == null && other.nr != null) || (this.nr != null && !this.nr.equals(other.nr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.entities.Savininkas[ nr=" + nr + " ]";
    }
    
}
