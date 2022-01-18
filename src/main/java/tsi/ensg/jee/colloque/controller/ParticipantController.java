package tsi.ensg.jee.colloque.controller;

import org.hibernate.Session;
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

    @GetMapping("/participants")
    public String create(Model model) {
        Participant participant = new Participant("Boby", "Lapointe",
                "boby.lapointe@jgv.com", "10/01/1975",
                "ENSG", "...");
        participantDao.save(participant);
        model.addAttribute("participants", participant); // Ajout au modèle
        return "participant";
    }



    @GetMapping("/participants/{num_person}")
    public String getParticipant(Model model, @PathVariable Long num_person) {
        Participant participant = participantDao.findById(num_person).get();
        //participantDao.save(part);
        model.addAttribute("participants", participant); // Ajout au modèle
        return "participant"; //Envoi vers la vue
    }
}
