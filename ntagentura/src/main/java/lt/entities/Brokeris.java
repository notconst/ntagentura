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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "BROKERIS")
@NamedQueries({
    @NamedQuery(name = "Brokeris.findAll", query = "SELECT b FROM Brokeris b"),
    @NamedQuery(name = "Brokeris.findById", query = "SELECT b FROM Brokeris b WHERE b.id = :id"),
    @NamedQuery(name = "Brokeris.findByAk", query = "SELECT b FROM Brokeris b WHERE b.ak = :ak"),
    @NamedQuery(name = "Brokeris.findByVardas", query = "SELECT b FROM Brokeris b WHERE b.vardas = :vardas"),
    @NamedQuery(name = "Brokeris.findByPavarde", query = "SELECT b FROM Brokeris b WHERE b.pavarde = :pavarde"),
    @NamedQuery(name = "Brokeris.findByTelefononr", query = "SELECT b FROM Brokeris b WHERE b.telefononr = :telefononr")})
public class Brokeris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AK")
    private long ak;
    @Size(max = 20)
    @Column(name = "VARDAS")
    private String vardas;
    @Size(max = 30)
    @Column(name = "PAVARDE")
    private String pavarde;
    @Column(name = "TELEFONONR")
    private BigInteger telefononr;
    @JoinTable(name = "BROKERIOOBJEKTAI", joinColumns = {
        @JoinColumn(name = "BROKERIOID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "OBJEKTONR", referencedColumnName = "NR")})
    @ManyToMany
    private List<Objektas> objektasList;

    public Brokeris() {
    }

    public Brokeris(Integer id) {
        this.id = id;
    }

    public Brokeris(Integer id, long ak) {
        this.id = id;
        this.ak = ak;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getAk() {
        return ak;
    }

    public void setAk(long ak) {
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

    public BigInteger getTelefononr() {
        return telefononr;
    }

    public void setTelefononr(BigInteger telefononr) {
        this.telefononr = telefononr;
    }

    public List<Objektas> getObjektasList() {
        return objektasList;
    }

    public void setObjektasList(List<Objektas> objektasList) {
        this.objektasList = objektasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.ak ^ (this.ak >>> 32));
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
        final Brokeris other = (Brokeris) obj;
        if (this.ak != other.ak) {
            return false;
        }
        return true;
    }

 


    @Override
    public String toString() {
        return "lt.entities.Brokeris[ id=" + id + " ]";
    }
    
}
