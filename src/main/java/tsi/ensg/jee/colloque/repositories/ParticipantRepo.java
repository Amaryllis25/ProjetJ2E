package tsi.ensg.jee.colloque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tsi.ensg.jee.colloque.metier.Participant;

@Repository
public interface ParticipantRepo extends CrudRepository<Participant, Long> {

}
