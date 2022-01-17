package tsi.ensg.jee.colloque.metier;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="evenement")
public class Evenement {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "num_even")
    private long numEvent;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private String beginDate;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int nbPartMax;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String organisator;

    @Column(nullable = false)
    private String typeEvent;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "num_person")
    private List<Participant> participants = new ArrayList<Participant>();

    public Evenement() {
    }

    public Evenement(String title, String theme, String beginDate,
                     int duration, int nbPartMax, String description,
                     String organisator, String typeEvent) {
        this.title = title;
        this.theme = theme;
        this.beginDate = beginDate;
        this.duration = duration;
        this.nbPartMax = nbPartMax;
        this.description = description;
        this.organisator = organisator;
        this.typeEvent = typeEvent;
    }

    public long getNumEvent() { return numEvent; }

    public void setNumEvent(long numEvent) { this.numEvent = numEvent; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public String getBeginDate() { return beginDate; }

    public void setBeginDate(String beginDate) { this.beginDate = beginDate; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public int getNbPartMax() { return nbPartMax; }

    public void setNbPartMax(int nbPartMax) { this.nbPartMax = nbPartMax; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getOrganisator() { return organisator; }

    public void setOrganisator(String organisator) { this.organisator = organisator; }

    public String getTypeEvent() { return typeEvent; }

    public void setTypeEvent(String typeEvent) { this.typeEvent = typeEvent; }

    public List<Participant> getParticipants() { return participants; }

    public void setParticipants(List<Participant> participants) { this.participants = participants; }

    public void addParticipant(Participant participant) { this.participants.add(participant); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return numEvent == evenement.numEvent && duration == evenement.duration && nbPartMax == evenement.nbPartMax && title.equals(evenement.title) && theme.equals(evenement.theme) && beginDate.equals(evenement.beginDate) && description.equals(evenement.description) && organisator.equals(evenement.organisator) && typeEvent.equals(evenement.typeEvent) && participants.equals(evenement.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEvent, title, theme, beginDate, duration, nbPartMax, description, organisator, typeEvent, participants);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "numEvent=" + numEvent +
                ", title='" + title + '\'' +
                ", theme='" + theme + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", duration=" + duration +
                ", nbPartMax=" + nbPartMax +
                ", description='" + description + '\'' +
                ", organisator='" + organisator + '\'' +
                ", typeEvent='" + typeEvent + '\'' +
                ", participants=" + participants +
                '}';
    }
}
