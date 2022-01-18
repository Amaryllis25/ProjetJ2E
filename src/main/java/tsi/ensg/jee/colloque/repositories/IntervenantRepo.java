package tsi.ensg.jee.colloque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tsi.ensg.jee.colloque.metier.Intervenant;

@Repository
public interface IntervenantRepo extends CrudRepository<Intervenant, Long> {

}
