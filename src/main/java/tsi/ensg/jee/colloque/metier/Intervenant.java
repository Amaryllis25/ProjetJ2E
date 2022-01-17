package tsi.ensg.jee.colloque.metier;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="intervenant")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Intervenant extends Participant {

    private String numTel;

    private String function;

    public Intervenant() {
    }

    public Intervenant(String firstName, String lastName,
                       String email, String birthDate,
                       String organisation, String observations,
                       String numTel, String function) {
        super(firstName, lastName, email, birthDate, organisation, observations);
        this.numTel = numTel;
        this.function = function;
    }

    public String getNumTel() { return numTel; }

    public void setNumTel(String numTel) { this.numTel = numTel; }

    public String getFunction() { return function; }

    public void setFunction(String function) { this.function = function; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Intervenant that = (Intervenant) o;
        return numTel.equals(that.numTel) && function.equals(that.function);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numTel, function);
    }

    @Override
    public String toString() {
        return  "Intervenant{" + super.toString() +
                ", numTel='" + numTel + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
