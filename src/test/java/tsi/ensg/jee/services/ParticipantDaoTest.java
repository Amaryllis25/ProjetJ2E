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

}
