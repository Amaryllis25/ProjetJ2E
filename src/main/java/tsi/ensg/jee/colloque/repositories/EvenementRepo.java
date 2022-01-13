package tsi.ensg.jee.colloque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tsi.ensg.jee.colloque.metier.Evenement;

@Repository
public interface EvenementRepo extends CrudRepository<Evenement, Long> {

}

