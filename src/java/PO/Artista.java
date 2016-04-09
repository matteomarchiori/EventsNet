/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\chen3046
 */

@Entity
@Table(name="Artista")
public class Artista {    
    @Id
    @GeneratedValue
    @Column(name="Id_Artista")
    private int id_artista;
    
    @Column(name="Nome")
    private String nome;
    
    @Column(name="Cognome")
    private String cognome;
    
    @Column(name="nome_arte")
    private String nome_arte;

    public Artista() {
    }

    public Artista(int id_artista, String nome, String cognome, String nome_arte) {
        this.id_artista = id_artista;
        this.nome = nome;
        this.cognome = cognome;
        this.nome_arte = nome_arte;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome_arte(String nome_arte) {
        this.nome_arte = nome_arte;
    }

    public int getId_artista() {
        return id_artista;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome_arte() {
        return nome_arte;
    }
    
    @ManyToMany (mappedBy="Id_Artista")
    private Set<Evento> eventi;
    

    
}
