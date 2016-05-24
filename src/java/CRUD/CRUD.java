/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import PO.Artista;
import PO.Categoria;
import PO.Commento;
import PO.Evento;
import PO.Utente;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.NamedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;

/**
 * Classe per operazioni Create Read Update Delete sul database
 */
public class CRUD {
    
    //variabili di esemplare
    private static SessionFactory factory;
    
    /**
     * Costruttore per un oggetto CRUD
     * @param factory : oggetto factory di default
     */
    public CRUD(SessionFactory factory){
        CRUD.factory = factory;
    }
    
    //INSERIMENTO
    
    //ARTISTA
    public void insertArtista(Artista a){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(a);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    //CATEGORIA
    public void insertCategoria(Categoria c){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(c);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    //COMMENTO
    public void insertCommento(Commento com){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(com);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    //EVENTO
    public void insertEvento(Evento ev){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(ev);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    //UTENTE
    public void insertUtente (Utente u){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(u);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    //SELEZIONARE
    
    //ARTISTA
     public List selectArtista(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Artista").addEntity(Artista.class);
            List<Artista> artisti = query.list();
            transazione.commit();
            return artisti;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT ARTISTA PER ID
    public Artista selectArtista(Integer id){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Artista where Id_Artista = "+id+";").addEntity(Artista.class);
            Artista a = null;
            if(!query.list().isEmpty()) a = (Artista) query.list().get(0);
            transazione.commit();
            return a;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT ARTISTA PER NOME D'ARTE
    public Artista selectArtista(String nome_arte){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Artista where nome_arte = "+nome_arte+";").addEntity(Artista.class);
            Artista a = null;
            if(!query.list().isEmpty()) a = (Artista) query.list().get(0);
            transazione.commit();
            return a;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    //CATEGORIA
    public List selectCategoria(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Categoria").addEntity(Categoria.class);
            List<Categoria> categorie = query.list();
            transazione.commit();
            return categorie;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT CATEGORIA PER ID
    public Categoria selectCategoria(Integer id){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Categoria where Id_Categoria = "+id+";").addEntity(Categoria.class);
            Categoria c = null;
            if(!query.list().isEmpty()) c = (Categoria) query.list().get(0);
            transazione.commit();
            return c;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT CATEGORIA PER NOME
    public Categoria selectCategoria(String nome){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Categoria where Nome = "+nome+";").addEntity(Categoria.class);
            Categoria c = null;
            if(!query.list().isEmpty()) c = (Categoria) query.list().get(0);
            transazione.commit();
            return c;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    //COMMENTO
    public List selectCommento(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Commento").addEntity(Commento.class);
            List<Commento> commento = query.list();
            transazione.commit();
            return commento;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT COMMENTO PER ID 
        public Commento selectCommento(Integer id){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Commento where Id_Commento = "+id+";").addEntity(Commento.class);
            Commento commento = null;
            if(!query.list().isEmpty()) commento = (Commento) query.list().get(0);
            transazione.commit();
            return commento;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    //EVENTO
    public List selectEvento(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Evento;").addEntity(Evento.class);
            List<Evento> eventi = query.list();
            transazione.commit();
            return eventi;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT EVENTO PER ID    
    public Evento selectEvento(Integer id){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Evento ev = null;
            query = sessione.createSQLQuery("select * from Evento where Id_Evento = \""+id+"\";").addEntity(Evento.class);
            if(!query.list().isEmpty()) ev = (Evento) query.list().get(0);
            transazione.commit();
            return ev;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT EVENTO PER LUOGO    
    public Evento selectEvento(String luogo){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Evento ev = null;
            query = sessione.createSQLQuery("select * from Evento where Luogo = \""+luogo+"\";").addEntity(Evento.class);
            if(!query.list().isEmpty()) ev = (Evento) query.list().get(0);
            transazione.commit();
            return ev;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT EVENTO PER DATA    
    public Evento selectEvento(Date data){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Evento ev = null;
            query = sessione.createSQLQuery("select * from Evento where Data = \""+data+"\";").addEntity(Evento.class);
            if(!query.list().isEmpty()) ev = (Evento) query.list().get(0);
            transazione.commit();
            return ev;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT EVENTO PER TITOLO    
    public Evento selectEventoT (String titolo){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Evento ev = null;
            query = sessione.createSQLQuery("select * from Evento where Titolo = \""+titolo+"\";").addEntity(Evento.class);
            if(!query.list().isEmpty()) ev = (Evento) query.list().get(0);
            transazione.commit();
            return ev;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    //UTENTE
    public List selectUtente(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Utente;").addEntity(Utente.class);
            List<Utente> utente = query.list();
            transazione.commit();
            return utente;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT UTENTE PER NICKNAME
    public Utente selectUtente(String nickname){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Utente u = null;
            query = sessione.createSQLQuery("select * from Utente where Nickname = \""+nickname+"\";").addEntity(Utente.class);
            if(!query.list().isEmpty()) u = (Utente) query.list().get(0);
            transazione.commit();
            return u;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT UTENTE PER NOME
    public Utente selectUtenteN (String nome){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Utente u = null;
            query = sessione.createSQLQuery("select * from Utente where Nome = \""+nome+"\";").addEntity(Utente.class);
            if(!query.list().isEmpty()) u = (Utente) query.list().get(0);
            transazione.commit();
            return u;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    //SELECT UTENTE PER COGNOME
    public Utente selectUtenteC (String cognome){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            Utente u = null;
            query = sessione.createSQLQuery("select * from Utente where Cognome = \""+cognome+"\";").addEntity(Utente.class);
            if(!query.list().isEmpty()) u = (Utente) query.list().get(0);
            transazione.commit();
            return u;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    //MODIFICARE
    
    //ARTISTA
    //UPDATE ID ARTISTA
    public void updateArtistaId(Integer id, Integer id_artista){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Artista a = (Artista) s.get(Artista.class, id);
            a.setIdArtista(id_artista);
            s.update(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE NOME ARTISTA
    public void updateArtistaNome(Integer id, String nome){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Artista a = (Artista) s.get(Artista.class, id);
            a.setNome(nome);
            s.update(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE COGNOME ARTISTA
    public void updateArtistaCognome(Integer id, String cognome){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Artista a = (Artista) s.get(Artista.class, id);
            a.setCognome(cognome);
            s.update(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE NOME_ARTE ARTISTA
    public void updateArtistaNomeArte(Integer id, String nome_arte){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Artista a = (Artista) s.get(Artista.class, id);
            a.setNomeArte(nome_arte);
            s.update(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //CATEGORIA
    //UPDATE ID CATEGORIA
    public void updateCategoriaId(Integer id, Integer id_categoria){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Categoria c = (Categoria) s.get(Categoria.class, id);
            c.setIdCategoria(id_categoria);
            s.update(c);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE NOME CATEGORIA
    public void updateCategoriaNome(Integer id, String nome){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Categoria c = (Categoria) s.get(Categoria.class, id);
            c.setNome(nome);
            s.update(c);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //COMMENTO
    //UPDATE ID COMMENTO
    public void updateCommentoId(Integer id, Integer id_commento){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Commento com = (Commento) s.get(Commento.class, id);
            com.setIdCommento(id_commento);
            s.update(com);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE TESTO COMMENTO
    public void updateCommentoTesto(Integer id, String testo){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Commento com = (Commento) s.get(Commento.class, id);
            com.setTesto(testo);
            s.update(com);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE VOTO COMMENTO
    public void updateCommentoVoto(Integer id, int voto){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Commento com = (Commento) s.get(Commento.class, id);
            com.setVoto(voto);
            s.update(com);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //EVENTO
    //UPDATE ID EVENTO
    public void updateEventoId(Integer id, Integer id_evento){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Evento ev = (Evento) s.get(Evento.class, id);
            ev.setIdEvento(id_evento);
            s.update(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE DATA EVENTO
    public void updateEventoData(Integer id, Date data){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Evento ev = (Evento) s.get(Evento.class, id);
            ev.setData(data);
            s.update(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE TITOLO EVENTO
    public void updateEventoTitolo(Integer id, String titolo){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Evento ev = (Evento) s.get(Evento.class, id);
            ev.setTitolo(titolo);
            s.update(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE LUOGO EVENTO
    public void updateEventoLuogo(Integer id, String luogo){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Evento ev = (Evento) s.get(Evento.class, id);
            ev.setLuogo(luogo);
            s.update(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //UTENTE
    //UPDATE NICKNAME UTENTE
    public void updateUtenteNickname(Integer id, String nickname){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Utente u = (Utente) s.get(Utente.class, id);
            u.setNickname(nickname);
            s.update(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE NOME UTENTE
    public void updateUtenteNome(Integer id, String nome){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Utente u = (Utente) s.get(Utente.class, id);
            u.setNome(nome);
            s.update(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    //UPDATE COGNOME UTENTE
    public void updateUtenteCognome(Integer id, String cognome){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Utente u = (Utente) s.get(Utente.class, id);
            u.setCognome(cognome);
            s.update(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }//UPDATE PASSWORD UTENTE
    public void updateUtentePassword(Integer id, String password){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Utente u = (Utente) s.get(Utente.class, id);
            u.setPassword(password);
            s.update(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //ELIMINARE
    //DELETE ARTISTA
    public void deleteArtista(Integer id){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Artista a = (Artista) s.get(Artista.class, id);
            s.delete(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //DELETE CATEGORIA
    public void deleteCategoria(Integer id){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Categoria c = (Categoria) s.get(Categoria.class, id);
            s.delete(c);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //DELETE COMMENTO
    public void deleteCommento(Integer id){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Commento com = (Commento) s.get(Commento.class, id);
            s.delete(com);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //DELETE EVENTO
    public void deleteEvento(Integer id){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Evento ev = (Evento) s.get(Evento.class, id);
            s.delete(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //DELETE UTENTE
    public void deleteUtente(Integer id){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t=s.beginTransaction();
            Utente u = (Utente) s.get(Utente.class, id);
            s.delete(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
}

