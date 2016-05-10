package PO;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author FSEVERI\chen3046
 */

@Entity
@Table(name="Utenti")
public class Utente implements Serializable {
    
    @Id
    @Column(name="Nickname")
    private String nickname;
    
    @Column(name="Nome")
    private String nome;
    
    @Column(name="Cognome")
    private String cognome;
    
    @Column(name="Password")
    private String password;
    
    
    @OneToMany(mappedBy="Nickname")
    private Set<Commento> commenti;
    
    @OneToMany(mappedBy="Nickname")
    private Set<Evento> eventi;
    
    @ManyToMany
    @JoinTable(
        name="Interessi",
        joinColumns={@JoinColumn(name="Nickname")},
        inverseJoinColumns={@JoinColumn(name="Id_Categoria")}     
    )
    private Set<Categoria> categorie;
    
    
    

    public Utente() {
    }

    public Utente(String nickname, String nome, String cognome, String Password) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
