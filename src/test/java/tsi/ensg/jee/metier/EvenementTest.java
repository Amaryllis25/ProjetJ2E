package tsi.ensg.jee.metier;

import org.junit.Assert;
import org.junit.Test;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class EvenementTest {

    @Test
    public void testDefaultConstructor() {
        Evenement evenement = new Evenement();
        assertNotNull(evenement);
    }

    @Test
    public void testDefaultConstructeurFullFilled() {
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        Assert.assertEquals("Undertale party", evenement.getTitle());
        Assert.assertEquals("Undertale", evenement.getTheme());
        Assert.assertEquals("22/04/2022", evenement.getBeginDate());
        Assert.assertEquals(3, evenement.getDuration());
        Assert.assertEquals(100000, evenement.getNbPartMax());
        Assert.assertEquals("Events for Undertale's fans", evenement.getDescription());
        Assert.assertEquals("Toby Fox", evenement.getOrganisator());
        Assert.assertEquals("Trailer", evenement.getTypeEvent());
    }

    @Test
    public void testDefaultConstructeurSetter() {
        Evenement evenement = new Evenement();
        Participant participant = new Participant("Amaryllis", "Vignaud", "avignaud@gateau.fr",
                "25/06/1999", "ENSG", "Fan d'Undertale");
        Participant participant2 = new Participant("ClaireMa", "Alla", "cmalla@gateau.fr",
                "25/04/1999", "ING3", "Fan de chocolat");

        List<Participant> participants = new ArrayList<>();
        participants.add(participant);

        evenement.setNumEvent(2);
        evenement.setTitle("Undertale party");
        evenement.setTheme("Undertale");
        evenement.setBeginDate("22/04/2022");
        evenement.setDuration(3);
        evenement.setNbPartMax(100000);
        evenement.setDescription("Events for Undertale's fans");
        evenement.setOrganisator("Toby Fox");
        evenement.setTypeEvent("Trailer");
        evenement.setParticipants(participants);
        evenement.addParticipant(participant2);

        Assert.assertEquals("Undertale party", evenement.getTitle());
        Assert.assertEquals("Undertale", evenement.getTheme());
        Assert.assertEquals("22/04/2022", evenement.getBeginDate());
        Assert.assertEquals(3, evenement.getDuration());
        Assert.assertEquals(100000, evenement.getNbPartMax());
        Assert.assertEquals("Events for Undertale's fans", evenement.getDescription());
        Assert.assertEquals("Toby Fox", evenement.getOrganisator());
        Assert.assertEquals("Trailer", evenement.getTypeEvent());
        Assert.assertEquals(participant, evenement.getParticipants().get(0));
        Assert.assertEquals(participant2, evenement.getParticipants().get(1));
    }

    @Test
    public void testMethodEqualsTrue(){
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        Evenement evenement2 = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        Assert.assertTrue(evenement.equals(evenement2));
    }

    @Test
    public void testMethodEqualsFalse(){
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        Evenement evenement2 = new Evenement("Treasures party", "Chasse au trésor", "10/06/2022", 7,
                100, "Competition for International Treasures Party Entrance", "Will Smith", "Game");

        Assert.assertFalse(evenement.equals(evenement2));
    }

    @Test
    public void testMethodEqualsSame(){
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        Assert.assertTrue(evenement.equals(evenement));
    }

    @Test
    public void testMethodEqualsNull(){
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        String participant2 = "Test";

        Assert.assertFalse(evenement.equals(null));
        Assert.assertFalse(evenement.equals(participant2));
    }

    @Test
    public void testHashCodeMethodTrue(){
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        Evenement evenement2 = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        Assert.assertTrue(evenement.hashCode() == evenement2.hashCode());
        Assert.assertTrue(evenement.equals(evenement2));
    }

    @Test
    public void testToStringMethod(){
        Evenement evenementToString = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");

        String participantToString = "Evenement{" +
                "numEvent=" + evenementToString.getNumEvent() +
                ", title='" + evenementToString.getTitle() + '\'' +
                ", theme='" + evenementToString.getTheme() + '\'' +
                ", beginDate='" + evenementToString.getBeginDate() + '\'' +
                ", duration=" + evenementToString.getDuration() +
                ", nbPartMax=" + evenementToString.getNbPartMax() +
                ", description='" + evenementToString.getDescription() + '\'' +
                ", organisator='" + evenementToString.getOrganisator() + '\'' +
                ", typeEvent='" + evenementToString.getTypeEvent() + '\'' +
                ", participants=" + evenementToString.getParticipants() +
                '}';

        Assert.assertEquals(participantToString, evenementToString.toString());
    }
}

