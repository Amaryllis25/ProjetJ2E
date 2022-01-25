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

/*
    //Get all employees whose Name or Last Name match the searchParam, order by name and last name.
    public List<Participant> searchEmployeesByName(String searchParam) {
        Comparator<Participant> groupByComparator = Comparator.comparing(Participant::getFirstName)
                                                    .thenComparing(Participant::getLastName);
        List<Participant> result = this.findAll()
                .stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(searchParam) || e.getLastName().equalsIgnoreCase(searchParam))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }
// https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/basic_app_embedded_tomcat/basic_app-tomcat-embedded.html
*/

    public Optional<Participant> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Participant participant) {
        repository.delete(participant);
    }
}
