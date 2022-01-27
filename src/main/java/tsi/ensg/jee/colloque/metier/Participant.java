package tsi.ensg.jee.colloque.metier;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="participant")
public class Participant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "numPerson")
    private long numPerson;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 5)
    private String firstName;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 5)
    private String lastName;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 10)
    private String email;

    @Column(nullable = false)
    private String birthDate;

    @Column(nullable = false)
    private String organisation;

    @Column(nullable = false)
    private String observations;

    public Participant() {
    }

    public Participant(String firstName, String lastName, String email,
                       String birthDate, String organisation, String observations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.organisation = organisation;
        this.observations = observations;
    }

    public long getNumPerson() { return numPerson; }

    public void setNumPerson(long numPerson) { this.numPerson = numPerson; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getOrganisation() { return organisation; }

    public void setOrganisation(String organisation) { this.organisation = organisation; }

    public String getObservations() { return observations; }

    public void setObservations(String observations) { this.observations = observations; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return numPerson == that.numPerson && firstName.equals(that.firstName) && lastName.equals(that.lastName) && email.equals(that.email) && birthDate.equals(that.birthDate) && organisation.equals(that.organisation) && observations.equals(that.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPerson, firstName, lastName, email, birthDate, organisation, observations);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "numPerson=" + numPerson +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", organisation='" + organisation + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }
}
