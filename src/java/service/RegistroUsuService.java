/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import hibernate.util.HibernateUtil;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Oriol Gasset
 */
public class RegistroUsuService {

    public Boolean registrar(Usuario usuario) {
        if (existeUsuario(usuario)) {
            return false;
        }

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(usuario);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public boolean existeUsuario(Usuario usuario) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userId='" + usuario.getUsername() + "'");
            Usuario u = (Usuario) query.uniqueResult();
            tx.commit();
            if (u != null) {
                result = true;
            }
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return result;

    }

}
