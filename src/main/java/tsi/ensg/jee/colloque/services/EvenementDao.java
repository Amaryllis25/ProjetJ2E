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

    public List<Evenement> findAll() {
        List<Evenement> evenements = (List<Evenement>) repository.findAll();
        return evenements;
    }

    public void save(Evenement evenement) {  // pas testé avec persist !
        repository.save(evenement);
    }

    public Optional<Evenement> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Evenement evenement) {
        repository.delete(evenement);
    }
}
