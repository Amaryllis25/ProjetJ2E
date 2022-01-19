package tsi.ensg.jee.colloque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.repositories.EvenementRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementDao {

    @Autowired
    private EvenementRepo repository;

    /**
     * Function which find all events in the repository
     * @return evenements
     */
    public List<Evenement> findAll() {
        List<Evenement> evenements = (List<Evenement>) repository.findAll();
        return evenements;
    }

    /**
     * Function which save a event in the repository
     * @param evenement data of an event
     */
    public void save(Evenement evenement) {  // pas testé avec persist !
        repository.save(evenement);
    }

    /**
     * Function which search an event by id and return it if exists
     * @param id id of the event
     * @return repository.findById(id)
     */
    public Optional<Evenement> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Function which delete an event
     * @param evenement data of an event
     * @return repository.findById(id)
     */
    public void delete(Evenement evenement) {
        repository.delete(evenement);
    }
}
