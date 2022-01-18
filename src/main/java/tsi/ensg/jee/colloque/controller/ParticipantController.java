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

    @GetMapping("/allParticipants")
    public String getParticipant(Model model) {
        //Participant part= new Participant("CMA", "Alla", "@", "06/12/99", "a", "b");
        //participantDao.save(part);
        model.addAttribute("allParticipants",participantDao.findAll()); // Ajout au modèle
        return "participants"; //Envoi vers la vue
    }
}
