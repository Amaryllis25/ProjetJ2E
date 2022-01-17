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

        Assert.assertEquals(0, participant.getNumPerson());
        Assert.assertEquals("Amaryllis", participant.getFirstName());
        Assert.assertEquals("Vignaud", participant.getLastName());
        Assert.assertEquals("avignaud@gateau.fr", participant.getEmail());
        Assert.assertEquals("25/06/1999", participant.getBirthDate());
        Assert.assertEquals("ENSG", participant.getOrganisation());
        Assert.assertEquals("Fan d'Undertale", participant.getObservations());
    }

    @Test
    public void testDefaultConstructeurSetter() {
        Participant participant = new Participant();

        participant.setNumPerson(1);
        participant.setFirstName("Amaryllis");
        participant.setLastName("Vignaud");
        participant.setEmail("avignaud@gateau.fr");
        participant.setBirthDate("25/06/1999");
        participant.setOrganisation("ENSG");
        participant.setObservations("Fan d'Undertale");

        Assert.assertEquals(1, participant.getNumPerson());
        Assert.assertEquals("Amaryllis", participant.getFirstName());
        Assert.assertEquals("Vignaud", participant.getLastName());
        Assert.assertEquals("avignaud@gateau.fr", participant.getEmail());
        Assert.assertEquals("25/06/1999", participant.getBirthDate());
        Assert.assertEquals("ENSG", participant.getOrganisation());
        Assert.assertEquals("Fan d'Undertale", participant.getObservations());
    }

    @Test
    public void testMethodEqualsTrue(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        Participant participant2 = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        Assert.assertTrue(participant.equals(participant2));
    }

    @Test
    public void testMethodEqualsFalse(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "M2TSI", "Fan d'Undertale");
        Participant participant2 = new Participant("ClaireMa", "Alla", "cmalla@gateau.fr",
                "25/04/1999", "ING3", "Fan de chocolat");

        Assert.assertFalse(participant.equals(participant2));
    }

    @Test
    public void testMethodEqualsSame(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        Assert.assertTrue(participant.equals(participant));
    }

    @Test
    public void testMethodEqualsNull(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        String participant2 = "Test";

        Assert.assertFalse(participant.equals(null));
        Assert.assertFalse(participant.equals(participant2));
    }

    @Test
    public void testHashCodeMethodTrue(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        Participant participant2 = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        Assert.assertTrue(participant.hashCode() == participant2.hashCode());
        Assert.assertTrue(participant.equals(participant2));
    }

    @Test
    public void testToStringMethod(){
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");

        String participantToString = "Participant{" +
                "numPerson=" + participant.getNumPerson() +
                ", firstName='" + participant.getFirstName() + '\'' +
                ", lastName='" + participant.getLastName() + '\'' +
                ", email='" + participant.getEmail() + '\'' +
                ", birthDate='" + participant.getBirthDate() + '\'' +
                ", organisation='" + participant.getOrganisation() + '\'' +
                ", observations='" + participant.getObservations() + '\'' +
                '}';

        Assert.assertEquals(participantToString, participant.toString());
    }
}
