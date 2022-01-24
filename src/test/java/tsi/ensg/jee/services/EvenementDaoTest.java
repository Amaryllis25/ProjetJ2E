package tsi.ensg.jee.services;

import org.junit.Assert;
import org.junit.Test;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.repositories.EvenementRepo;
import tsi.ensg.jee.colloque.services.EvenementDao;
import tsi.ensg.jee.colloque.services.ParticipantDao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class EvenementDaoTest {

    @Test
    public void testDefaultConstructor() {
        EvenementDao evenementDao = new EvenementDao();
        assertNotNull(evenementDao);
    }
/*
    @Test
    public void testCreateMethod() {
        EvenementRepo repository;
        EvenementDao evenementDao = new EvenementDao();

        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        evenement.setNumEvent(1);

        evenementDao.save(evenement);

        System.out.println("test");

        Assert.assertEquals(evenement, evenementDao.findById(1L).get());
    }
/*
    @Test
    public void testDeleteMethod() {
        EvenementDao evenementDao = new EvenementDao();

        long e1 = evenementDao.create("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        long e2 = evenementDao.create("Treasures party", "Chasse au trésor", "10/06/2022", 7,
                100, "Competition for International Treasures Party Entrance", "Will Smith", "Game");

        evenementDao.delete(e1);

        Assert.assertEquals(1, evenementDao.getAll().size());
    }

    @Test
    public void testUpdateMethod() {
        EvenementDao evenementDao = new EvenementDao();

        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        long e1 = evenementDao.create("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        evenement.setTheme("AU Undertale");

        evenementDao.update(e1, evenement);

        Assert.assertEquals("AU Undertale", evenementDao.get(e1).getTheme());
    }

    @Test
    public void testUpdateParticipantMethod() {
        EvenementDao evenementDao = new EvenementDao();

        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        long e1 = evenementDao.create("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        participant.setNumPerson(1);

        evenementDao.update(e1, participant);

        Assert.assertEquals(participant, evenementDao.get(e1).getParticipants().get(0));
    }*/
}
