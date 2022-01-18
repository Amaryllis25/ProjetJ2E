package tsi.ensg.jee.colloque.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.ensg.jee.colloque.metier.Intervenant;
import tsi.ensg.jee.colloque.repositories.IntervenantRepo;

import java.util.List;
import java.util.Optional;

@Service
public class IntervenantDao{

    @Autowired
    private IntervenantRepo repository;

    public List<Intervenant> findAll() {
        List<Intervenant> intervenants = (List<Intervenant>) repository.findAll();
        return intervenants;
    }

    public void save(Intervenant intervenant) {  // pas testé avec persist !
        repository.save(intervenant);
    }

    public Optional<Intervenant> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Intervenant intervenant) {
        repository.delete(intervenant);
    }
}
