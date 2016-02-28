/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 *
 * @author AsusPC
 */
@Entity
@Table(name = "OBJEKTAS")
@NamedQueries({
    @NamedQuery(name = "Objektas.findAll", query = "SELECT o FROM Objektas o"),
    @NamedQuery(name = "Objektas.findByNr", query = "SELECT o FROM Objektas o WHERE o.nr = :nr"),
    @NamedQuery(name = "Objektas.findByVienetokaina", query = "SELECT o FROM Objektas o WHERE o.vienetokaina = :vienetokaina"),
    @NamedQuery(name = "Objektas.findByMatavimovienetas", query = "SELECT o FROM Objektas o WHERE o.matavimovienetas = :matavimovienetas"),
    @NamedQuery(name = "Objektas.findByPlotas", query = "SELECT o FROM Objektas o WHERE o.plotas = :plotas"),
    @NamedQuery(name = "Objektas.findByMiestas", query = "SELECT o FROM Objektas o WHERE o.miestas = :miestas"),
    @NamedQuery(name = "Objektas.findByAdresas", query = "SELECT o FROM Objektas o WHERE o.adresas = :adresas"),
    @NamedQuery(name = "Objektas.findByKategorija", query = "SELECT o FROM Objektas o WHERE o.kategorija = :kategorija"),
    @NamedQuery(name = "Objektas.findByTipas", query = "SELECT o FROM Objektas o WHERE o.tipas = :tipas")})
public class Objektas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NR")
    private Integer nr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIENETOKAINA")
    private float vienetokaina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MATAVIMOVIENETAS")
    private String matavimovienetas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLOTAS")
    private float plotas;
    @Size(max = 20)
    @Column(name = "MIESTAS")
    private String miestas;
    @Size(max = 50)
    @Column(name = "ADRESAS")
    private String adresas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "KATEGORIJA")
    private String kategorija;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPAS")
    private String tipas;
    @ManyToMany(mappedBy = "objektasList")
    private List<Brokeris> brokerisList= new ArrayList<>();
    @JoinColumn(name = "SAVININKONR", referencedColumnName = "NR")
    @ManyToOne(optional = false)
    private Savininkas savininkonr;

    public Objektas() {
    }

    public Objektas(Integer nr) {
        this.nr = nr;
    }

    public Objektas(Integer nr, float vienetokaina, String matavimovienetas, float plotas, String kategorija, String tipas) {
        this.nr = nr;
        this.vienetokaina = vienetokaina;
        this.matavimovienetas = matavimovienetas;
        this.plotas = plotas;
        this.kategorija = kategorija;
        this.tipas = tipas;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public float getVienetokaina() {
        return vienetokaina;
    }

    public void setVienetokaina(float vienetokaina) {
        this.vienetokaina = vienetokaina;
    }

    public String getMatavimovienetas() {
        return matavimovienetas;
    }

    public void setMatavimovienetas(String matavimovienetas) {
        this.matavimovienetas = matavimovienetas;
    }

    public float getPlotas() {
        return plotas;
    }

    public void setPlotas(float plotas) {
        this.plotas = plotas;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public List<Brokeris> getBrokerisList() {
        return brokerisList;
    }

    public void setBrokerisList(List<Brokeris> brokerisList) {
        this.brokerisList = brokerisList;
    }

    public Savininkas getSavininkonr() {
        return savininkonr;
    }

    public void setSavininkonr(Savininkas savininkonr) {
        this.savininkonr = savininkonr;
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
        if (!(object instanceof Objektas)) {
            return false;
        }
        Objektas other = (Objektas) object;
        if ((this.nr == null && other.nr != null) || (this.nr != null && !this.nr.equals(other.nr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.entities.Objektas[ nr=" + nr + " ]";
    }
    
}
