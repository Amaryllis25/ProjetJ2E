package tsi.ensg.jee.colloque.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import tsi.ensg.jee.colloque.metier.Participant;
import java.util.List;

public class HibernateUtils {

    public final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory createSessionFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }

    public void insert(Participant participant){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
    }

    public List<Participant> getAllEmployee(){
        Session session = sessionFactory.openSession();
        List<Participant> result = session.createQuery("from Employee").list();
        session.close();
        return result;
    }
}
