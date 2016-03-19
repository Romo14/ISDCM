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

public class LoginUsuService {

    public boolean comprobar(String nickname, String password) {
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Usuario where nickName='" + nickname + "'"+" and password='"+password+"'");
            Usuario u = (Usuario) query.uniqueResult();
            tx.commit();
            if (u != null) {
                return true;
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

    }

}

