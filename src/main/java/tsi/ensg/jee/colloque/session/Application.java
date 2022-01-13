package tsi.ensg.jee.colloque.session;

import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.EvenementDao;
import tsi.ensg.jee.colloque.services.IntervenantDao;
import tsi.ensg.jee.colloque.services.ParticipantDao;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        /*
        EvenementDao daoEvent = new EvenementDao();
        ParticipantDao daoPart = new ParticipantDao();
        IntervenantDao daoInter = new IntervenantDao();

        long forum = daoEvent.create("Forum des entreprises", "stage",
                "22/11/20221", 160, 143,
                "Entreprise se présenten.", "AAE",  "Pro");

        long boby = daoPart.create("Boby", "Lapointe",
                "boby.lapointe@jgv.com", "10/01/1975",
                "ENSG", "...");
        long boris = daoPart.create("Boris", "Vian",
                "boris.vian@jgv.com", "10/01/1947",
                "ENSG", "...");
        long lisa = daoPart.create("Lisa", "Simpson",
                "lisa.simspson@jgv.com", "10/01/2002",
                "ENSG", "...");
        long marge = daoPart.create("Marge", "Simpson",
                "marge.simspson@jgv.com", "10/01/1981",
                "ENSG", "...");
        long homer = daoPart.create("Homer", "Simpson",
                "homer.simspson@jgv.com", "10/01/1979",
                "ENSG", "...");

        long vincent = daoInter.create("Victor", "Coindet",
                "victor.coindet@jgv.com", "10/01/1982",
                "ENSG", "...",
                "4646516874684", "Président AAE");

        List<Participant> participants = daoPart.getAll();
        System.out.println(participants);

        daoEvent.update(forum, daoPart.get(boby));
        daoEvent.update(forum, daoPart.get(boris));
        daoEvent.update(forum, daoPart.get(vincent));
        System.out.println(daoEvent.getAll());

        System.out.println(daoInter.getAll());
         */
    }
}
