package tsi.ensg.jee.colloque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.ensg.jee.colloque.repositories.ParticipantRepo;
import tsi.ensg.jee.colloque.metier.Participant;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantDao {

    @Autowired
    private ParticipantRepo repository;

    public List<Participant> findAll() {
        List<Participant> participants = (List<Participant>) repository.findAll();
        return participants;
    }

    public void save(Participant participant) {  // pas testé avec persist !
        repository.save(participant);
    }

    public Optional<Participant> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Participant participant) {
        repository.delete(participant);
    }
}
