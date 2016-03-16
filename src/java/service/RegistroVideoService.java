/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Marc
 */

import hibernate.util.HibernateUtil;
import model.Usuario;
import model.Video;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RegistroVideoService {
    
    public String registrar(Video video) {
        
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(video);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return e.getMessage();
        } finally {
            session.close();
        }
        return "Registro realizado correctamente";
    }

    /*public boolean existeUsuario(Usuario usuario) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Usuario where nickName='" + usuario.getUsername() + "'");
            Usuario u = (Usuario) query.uniqueResult();
            tx.commit();
            if (u != null) {
                result = true;
            }
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        return result;

    }*/
    
}
