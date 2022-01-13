package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Intervenant;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.session.HibernateUtils;

import java.util.List;

public class IntervenantDao{

    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public IntervenantDao() {
    }

    public long create(String firstName, String lastName, String email,
                       String birth_date, String organisation,
                       String observations, String numTel, String function) {
        Intervenant intervenant = new Intervenant(firstName, lastName, email,
                    birth_date, organisation, observations,
                    numTel, function);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(intervenant);
        session.getTransaction().commit();
        session.close();
        return intervenant.getNumPerson();
    }

    public boolean delete(long id) {
        Intervenant intervenantToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(intervenantToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(long id) {
        Intervenant intervenantToUpdate = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(intervenantToUpdate);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Intervenant get(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Intervenant result = session.get(Intervenant.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Intervenant> getAll() {
        Session session = sessionFactory.openSession();
        List<Intervenant> result = session.createQuery("from Intervenant").list();
        session.close();
        return result;
    }
}
