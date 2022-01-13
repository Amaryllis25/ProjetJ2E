package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.session.HibernateUtils;
import tsi.ensg.jee.colloque.metier.Participant;

import java.util.List;

public class ParticipantDao {
    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public ParticipantDao() {
    }

    public long create(String firstName, String lastName, String email,
                       String birth_date, String organisation, String observations) {
        Participant participant = new Participant(firstName, lastName, email,
                birth_date, organisation, observations);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getNumPerson();
    }

    public boolean delete(long id) {
        Participant participantToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(participantToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean update(long id) {
        Participant participantToUpdate = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(participantToUpdate);
        session.getTransaction().commit();
        session.close();
        return true;
    }

        public Participant get(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Participant result = session.get(Participant.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Participant> getAll() {
        Session session = sessionFactory.openSession();
        List<Participant> result = session.createQuery("from Participant").list();
        session.close();
        return result;
    }
}
