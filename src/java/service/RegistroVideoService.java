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
import model.Video;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RegistroVideoService {
    
    public String registrar(Video video) {
        
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(video);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return "ko";
        } finally {
            session.close();
        }
        return "ok";
    }

    
}
