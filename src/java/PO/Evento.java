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
@Table(name="Evento")
public class Evento {
    
    @Id
    @GeneratedValue
    @Column(name="Id_Evento")
    private int id_evento;
    
    @Column(name="Data")
    private Date data;
    
    @Column(name="Luogo")
    private String luogo;
    
    @Column(name="Titolo")
    private String titolo;
    
    @ManyToMany
    @JoinTable(
        name="Coinvolgimento",
        joinColumns={@JoinColumn(name="Id_Evento")},
        inverseJoinColumns={@JoinColumn(name="Id_Artista")}     
    )
    private Set<Artista> artisti;
    
    
    @ManyToOne
    @JoinColumn(name="Id_Categoria")
    private String cat;
    
    @OneToMany(mappedBy="Id_Evento")
    private Set<Commento> commenti;
    
    
    
    

    public Evento() {
    }

    public Evento(int id_evento, Date data, String luogo, String titolo) {
        this.id_evento = id_evento;
        this.data = data;
        this.luogo = luogo;
        this.titolo = titolo;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getId_evento() {
        return id_evento;
    }

    public Date getData() {
        return data;
    }

    public String getLuogo() {
        return luogo;
    }

    public String getTitolo() {
        return titolo;
    }
    
    
    
    
    

    
}
