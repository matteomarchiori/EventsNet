/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matteo
 */
@Entity
@Table(name = "Eventi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByData", query = "SELECT e FROM Evento e WHERE e.data = :data"),
    @NamedQuery(name = "Evento.findByLuogo", query = "SELECT e FROM Evento e WHERE e.luogo = :luogo"),
    @NamedQuery(name = "Evento.findByTitolo", query = "SELECT e FROM Evento e WHERE e.titolo = :titolo")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Evento")
    private Integer idEvento;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Luogo")
    private String luogo;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    @JoinTable(name = "Coinvolgimenti", joinColumns = {
        @JoinColumn(name = "Id_Evento", referencedColumnName = "Id_Evento")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Artista", referencedColumnName = "Id_Artista")})
    @ManyToMany
    private Set<Artista> artistaSet;
    @JoinColumn(name = "Nickname", referencedColumnName = "Nickname")
    @OneToOne(optional = false)
    private Utente nickname;
    @JoinColumn(name = "Id_Categoria", referencedColumnName = "Id_Categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private Set<Commento> commentoSet;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Integer idEvento, Date data, String luogo, String titolo) {
        this.idEvento = idEvento;
        this.data = data;
        this.luogo = luogo;
        this.titolo = titolo;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @XmlTransient
    public Set<Artista> getArtistaSet() {
        return artistaSet;
    }

    public void setArtistaSet(Set<Artista> artistaSet) {
        this.artistaSet = artistaSet;
    }

    public Utente getNickname() {
        return nickname;
    }

    public void setNickname(Utente nickname) {
        this.nickname = nickname;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Set<Commento> getCommentoSet() {
        return commentoSet;
    }

    public void setCommentoSet(Set<Commento> commentoSet) {
        this.commentoSet = commentoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PO.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
