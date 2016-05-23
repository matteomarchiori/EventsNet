/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matteo
 */
@Entity
@Table(name = "Utenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findByNickname", query = "SELECT u FROM Utente u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utente.findByCognome", query = "SELECT u FROM Utente u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Cognome")
    private String cognome;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @JoinTable(name = "Interessi", joinColumns = {
        @JoinColumn(name = "Nickname", referencedColumnName = "Nickname")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Categoria", referencedColumnName = "Id_Categoria")})
    @ManyToMany
    private Set<Categoria> categoriaSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nickname")
    private Evento evento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nickname")
    private Set<Commento> commentoSet;

    public Utente() {
    }

    public Utente(String nickname) {
        this.nickname = nickname;
    }

    public Utente(String nickname, String nome, String cognome, String password) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Set<Categoria> getCategoriaSet() {
        return categoriaSet;
    }

    public void setCategoriaSet(Set<Categoria> categoriaSet) {
        this.categoriaSet = categoriaSet;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PO.Utente[ nickname=" + nickname + " ]";
    }
    
}
