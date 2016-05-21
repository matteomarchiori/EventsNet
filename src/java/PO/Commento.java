/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\chen3046
 */

@Entity
@Table(name="Commenti")

public class Commento implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="Id_Commento")
    private int id_commento;
    
    @Column(name="Testo")
    private String commento_testo;
    
    @Column(name="Voto")
    private int commento_voto;
    
    @ManyToOne
    @JoinColumn(name="Nickname")
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name="Id_Evento")
    private Evento evento;
    
    
    

    public Commento() {
    }

    public Commento(String commento_testo, int commento_voto, Utente utente, Evento evento) {
        this.commento_testo = commento_testo;
        this.commento_voto = commento_voto;
        this.utente = utente;
    }

    public void setId_commento(int id_commento) {
        this.id_commento = id_commento;
    }

    public void setCommento_testo(String commento_testo) {
        this.commento_testo = commento_testo;
    }

    public void setCommento_voto(int commento_voto) {
        this.commento_voto = commento_voto;
    }

    public void setCommento_nickname(Utente utente) {
        this.utente = utente;
    }

    public void setCommento_evento(Evento evento) {
        this.evento = evento;
    }

    public int getId_commento() {
        return id_commento;
    }

    public String getCommento_testo() {
        return commento_testo;
    }

    public int getCommento_voto() {
        return commento_voto;
    }

    public Utente getCommento_nickname() {
        return utente;
    }

    public Evento getCommento_evento() {
        return evento;
    }
    
    
}
