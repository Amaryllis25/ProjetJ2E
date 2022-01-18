package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    @GetMapping("/participant")
    public String create(Model model) {
        Participant participant = new Participant("Boby", "Lapointe",
                "boby.lapointe@jgv.com", "10/01/1975",
                "ENSG", "...");
        participantDao.save(participant);
        model.addAttribute("participant", participant); // Ajout au modèle
        return "participant";
    }

    @GetMapping("/participant/{num_person}")
    public String getParticipant(Model model, @PathVariable Long num_person) {
        if (participantDao.findById(num_person).isPresent()){
            Participant participant = participantDao.findById(num_person).get();
            //participantDao.save(part);
            model.addAttribute("participant", participant); // Ajout au modèle
        }
        return "participant"; //Envoi vers la vue
    }

    @GetMapping("/allParticipants")
    public String getParticipants(Model model) {
        Participant part= new Participant("CMA", "Alla", "@", "06/12/99", "a", "b");
        participantDao.save(part);

        Participant part2= new Participant("CMA", "Alla", "@", "06/12/99", "a", "b");
        participantDao.save(part2);
        model.addAttribute("allParticipants",participantDao.findAll()); // Ajout au modèle
        return "participants"; //Envoi vers la vue
    }

    @GetMapping("/createParticipant")
    public String createParticipant(Model model) {
        return "createParticipant"; //Envoi vers la vue
    }
}
