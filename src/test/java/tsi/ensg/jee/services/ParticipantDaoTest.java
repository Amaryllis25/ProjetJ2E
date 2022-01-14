package tsi.ensg.jee.services;

import org.junit.Assert;
import org.junit.Test;

import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

import static org.junit.Assert.assertNotNull;

public class ParticipantDaoTest {

    @Test
    public void testDefaultConstructor() {
        ParticipantDao participantDao = new ParticipantDao();
        assertNotNull(participantDao);
    }
    
    @Test
    public void testCreateMethod() {
        ParticipantDao participantDao = new ParticipantDao();

        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        participant.setNumPerson(1);
        long p1 = participantDao.create("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        Assert.assertEquals(participant, participantDao.get(p1));
    }
/*
    @Test
    public void testDeleteMethod() {
        ParticipantDao participantDao = new ParticipantDao();

        long p1 = participantDao.create("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        long p2 = participantDao.create("ClaireMa", "Alla", "cmalla@gateau.fr",
                "25/04/1999", "ING3", "Fan de chocolat");

        participantDao.delete(p1);

        Assert.assertEquals(1, participantDao.getAll().size());
    }

    @Test
    public void testUpdateMethod() {
        ParticipantDao participantDao = new ParticipantDao();

        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        long p1 = participantDao.create("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        participant.setOrganisation("Pokemon");

        System.out.println(participantDao.get(p1).getClass());

        participantDao.update(p1, participant);

        Assert.assertEquals("Pokemon", participantDao.get(p1).getOrganisation());
    }*/
}
