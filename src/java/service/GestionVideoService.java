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
import java.util.ArrayList;
import java.util.List;
import model.Video;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GestionVideoService {

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

    public List<Video> buscar(Video video) {
        List<Video> result = new ArrayList<Video>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Criteria criteria = session.createCriteria(Video.class);
            if (!video.getTitulo().equals("")) {
                criteria.add(Restrictions.ilike("titulo", "%" + video.getTitulo() + "%"));
            }
            if (!video.getAutor().equals("")) {
                criteria.add(Restrictions.ilike("autor", "%" + video.getAutor() + "%"));
            }
            if (!video.getDescripcion().equals("")) {
                criteria.add(Restrictions.ilike("descripcion", "%" + video.getDescripcion() + "%"));
            }
            if (!video.getFormato().equals("")) {
                criteria.add(Restrictions.ilike("formato", "%" + video.getFormato() + "%"));
            }
            if (video.getFechaCreacion() != null) {
                criteria.add(Restrictions.eq("fechaCreacion", video.getFechaCreacion()));
            }
            if (video.getDuracion() != null) {
                criteria.add(Restrictions.eq("duracion", video.getDuracion()));
            }
            result = criteria.list();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            session.close();
        }

        return result;
    }

}
