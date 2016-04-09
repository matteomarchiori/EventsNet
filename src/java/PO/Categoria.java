/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\chen3046
 */

@Entity
@Table(name="Categorie")
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="Id_Categoria")
    private int id_categoria;
    
    @Column(name="Nome")
    private String nome;
    
    @OneToMany(mappedBy="Id_Categoria")
    private Set<Evento> eventi;
    
    @ManyToMany
    @JoinTable(
        name="Interessi",
        joinColumns={@JoinColumn(name="Id_Categoria")},
        inverseJoinColumns={@JoinColumn(name="Nickname")}     
    )
    private Set<Utente> utenti;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public String getNome() {
        return nome;
    }
    
}
