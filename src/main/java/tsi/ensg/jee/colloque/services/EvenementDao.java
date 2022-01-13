package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.session.HibernateUtils;

import java.util.Date;
import java.util.List;

public class EvenementDao {

    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public EvenementDao() {
    }

    public long create(String title, String theme, String beginDate,
                       int duration, int nbPartMax, String description,
                       String organisator, String typeEvent) {
        Evenement evenement = new Evenement(title, theme, beginDate,
                        duration, nbPartMax, description,
                        organisator, typeEvent);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(evenement);
        session.getTransaction().commit();
        session.close();
        return evenement.getNumEvent();
    }

    public boolean delete(long id) {
        Evenement evenementToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(evenementToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(long id, Participant participant) {
        Evenement evenementToUpdate = this.get(id);
        evenementToUpdate.addParticpant(participant);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(evenementToUpdate);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Evenement get(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Evenement result = session.get(Evenement.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Evenement> getAll() {
        Session session = sessionFactory.openSession();
        List<Evenement> result = session.createQuery("from Evenement").list();
        session.close();
        return result;
    }
}
