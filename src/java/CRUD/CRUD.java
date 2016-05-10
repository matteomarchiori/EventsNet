/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import PO.*;
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
    
    public Utente selectUtente(String nick){
       Session sessione = factory.openSession();
        Transaction transazione = null;
        SQLQuery query;
        try{
            transazione = sessione.beginTransaction();
            query = sessione.createSQLQuery("select * from Utenti where Nickname = \""+nick+"\";").addEntity(Utente.class);
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
    }
    
}