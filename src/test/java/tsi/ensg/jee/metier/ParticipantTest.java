package tsi.ensg.jee.metier;

import org.junit.Assert;
import org.junit.Test;
import tsi.ensg.jee.colloque.metier.Participant;

import static org.junit.Assert.assertNotNull;

public class ParticipantTest {

    @Test
    public void testDefaultConstructor() {
        Participant participant = new Participant();
        assertNotNull(participant);
    }

    @Test
    public void testDefaultConstructeurFullFilled() {
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                                                "25/06/1999", "ENSG", "Fan d'Undertale");
        Assert.assertEquals("Amaryllis", participant.getFirstName());
        Assert.assertEquals("Vignaud", participant.getLastName());
    }
}
