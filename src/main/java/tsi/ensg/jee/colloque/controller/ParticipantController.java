package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    @GetMapping("/participants")
    public String getParticipant(Model model) {
        Participant participant = new Participant("CMA", "Alla", "@", "06/12/99", "a", "b");
        //ParticipantDao participants = new ParticipantDao();
        //participants.save(part);
        model.addAttribute("participants",participant); // Ajout au modèle
        return "participant"; //Envoi vers la vue
    }
}
