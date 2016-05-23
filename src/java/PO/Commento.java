/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matteo
 */
@Entity
@Table(name = "Commenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commento.findAll", query = "SELECT c FROM Commento c"),
    @NamedQuery(name = "Commento.findByIdCommento", query = "SELECT c FROM Commento c WHERE c.idCommento = :idCommento"),
    @NamedQuery(name = "Commento.findByTesto", query = "SELECT c FROM Commento c WHERE c.testo = :testo"),
    @NamedQuery(name = "Commento.findByVoto", query = "SELECT c FROM Commento c WHERE c.voto = :voto")})
public class Commento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Commento")
    private Integer idCommento;
    @Basic(optional = false)
    @Column(name = "Testo")
    private String testo;
    @Basic(optional = false)
    @Column(name = "Voto")
    private int voto;
    @JoinColumn(name = "Nickname", referencedColumnName = "Nickname")
    @ManyToOne(optional = false)
    private Utente nickname;
    @JoinColumn(name = "Id_Evento", referencedColumnName = "Id_Evento")
    @ManyToOne(optional = false)
    private Evento idEvento;

    public Commento() {
    }

    public Commento(Integer idCommento) {
        this.idCommento = idCommento;
    }

    public Commento(Integer idCommento, String testo, int voto) {
        this.idCommento = idCommento;
        this.testo = testo;
        this.voto = voto;
    }

    public Integer getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(Integer idCommento) {
        this.idCommento = idCommento;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Utente getNickname() {
        return nickname;
    }

    public void setNickname(Utente nickname) {
        this.nickname = nickname;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommento != null ? idCommento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commento)) {
            return false;
        }
        Commento other = (Commento) object;
        if ((this.idCommento == null && other.idCommento != null) || (this.idCommento != null && !this.idCommento.equals(other.idCommento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PO.Commento[ idCommento=" + idCommento + " ]";
    }
    
}
