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
    /**
    public Utente selectUtente(String nick){
       Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("Artista.findAll");
            Utente u = null;
            if(!query.list().isEmpty()) u = (Utente) query.list().get(0);
            transazione.commit();
            return u;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }*/
    
    //su ARTISTA
    //CREATE
    public void createArtista (Artista a){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            s.save(a);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //READ
    public List readArtista(){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            List artisti = s.createQuery("FROM Artista").list();
            t.commit();
            return artisti;
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
        return null;
    }
    public Artista readArtista(Integer id){
        List artisti=readArtista();
        Artista a;
        for(Iterator i=artisti.iterator(); i.hasNext();){
            a=(Artista)i.next();
            if(a.getIdArtista()==id)return a;
        }
        return null;
    }
    
    //UPDATE
    public void updateArtista(Integer id, String nome){
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
    
    //DELETE
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
    //su CATEGORIA
    //CREATE
    public void createCategoria (Categoria c){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            s.save(c);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //READ
    public List readCategoria(){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            List categorie = s.createQuery("FROM Categoria").list();
            t.commit();
            return categorie;
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
        return null;
    }
    public Categoria readCategoria(Integer id){
        List categorie = readCategoria();
        Categoria c;
        for(Iterator i=categorie.iterator(); i.hasNext();){
            c=(Categoria)i.next();
            if(c.getIdCategoria()==id)return c;
        }
        return null;
    }
    
    //UPDATE
    public void updateCategoria(Integer id, String nome){
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
    
    //DELETE
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
    //su COMMENTO
    //CREATE
    public void createCommento (Commento com){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            s.save(com);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //READ
    public List readCommento(){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            List commenti = s.createQuery("FROM Commento").list();
            t.commit();
            return commenti;
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
        return null;
    }
    public Commento readCommento (Integer id){
        List commenti=readCommento();
        Commento com;
        for(Iterator i=commenti.iterator(); i.hasNext();){
            com=(Commento)i.next();
            if(com.getIdCommento()==id)return com;
        }
        return null;
    }
    
    //UPDATE
    public void updateCommento(Integer id, String testo){
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
    
    //DELETE
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
    //su EVENO
    //CREATE
    public void createEvento (Evento ev){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            s.save(ev);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //READ
    public List readEvento(){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            List eventi = s.createQuery("FROM Evento").list();
            t.commit();
            return eventi;
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
        return null;
    }
    public Evento readEventi(Integer id){
        List eventi=readEvento();
        Evento ev;
        for(Iterator i=eventi.iterator(); i.hasNext();){
            ev=(Evento)i.next();
            if(ev.getIdEvento()==id)return ev;
        }
        return null;
    }
    
    //UPDATE
    public void updateEvetno(Integer id, String titolo){
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
    
    //DELETE
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
    //su UTENTE
    //CREATE
    public void createUtente (Utente u){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            s.save(u);
            t.commit();
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
    }
    
    //READ
    public List readUtente(){
        Session s = factory.openSession();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            List utenti = s.createQuery("FROM Utente").list();
            t.commit();
            return utenti;
        }catch(HibernateException e){
            if(t!=null) t.rollback();
        }finally{
            s.close();
        }
        return null;
    }
    public Utente readUtente(String id){
        List utenti=readUtente();
        Utente u;
        for(Iterator i=utenti.iterator(); i.hasNext();){
            u=(Utente)i.next();
            if(u.getNickname()==id)return u;
        }
        return null;
    }
    
    //UPDATE
    public void updateUtente(Integer id, String nome){
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
    
    //DELETE
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