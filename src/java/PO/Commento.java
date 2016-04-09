/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\chen3046
 */

@Entity
@Table(name="Commento")

public class Commento {
    
    @Id
    @GeneratedValue
    @Column(name="Id_Commento")
    private int id_commento;
    
    @Column(name="Testo")
    private String commento_testo;
    
    @Column(name="Voto")
    private int commento_voto;
    
    @Column(name="Nickname")
    private int commento_nickname;
    
    @Column(name="Id_evento")
    private int commento_evento;
    
    @ManyToOne
    @JoinColumn(name="Nickname")
    private String utenti;
    
    @ManyToOne
    @JoinColumn(name="Id_Evento")
    private String eventi;
    
    
    

    public Commento() {
    }

    public Commento(int id_commento, String commento_testo, int commento_voto, int commento_nickname, int commento_evento) {
        this.id_commento = id_commento;
        this.commento_testo = commento_testo;
        this.commento_voto = commento_voto;
        this.commento_nickname = commento_nickname;
        this.commento_evento = commento_evento;
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

    public void setCommento_nickname(int commento_nickname) {
        this.commento_nickname = commento_nickname;
    }

    public void setCommento_evento(int commento_evento) {
        this.commento_evento = commento_evento;
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

    public int getCommento_nickname() {
        return commento_nickname;
    }

    public int getCommento_evento() {
        return commento_evento;
    }
    
    
}
