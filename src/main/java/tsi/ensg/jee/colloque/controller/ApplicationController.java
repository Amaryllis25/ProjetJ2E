package tsi.ensg.jee.colloque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ApplicationController {

    @GetMapping("/participant")
    public String getParticipant(Model model) {
        ParticipantDao daoPart = new ParticipantDao();
        long lisa = daoPart.create("Lisa", "Simpson",
                "lisa.simspson@jgv.com", "10/01/2002",
                "ENSG", "...");
        model.addAttribute("participant", lisa); // Ajout au modèle
        return "participant"; //Envoi vers la vue
    }
}
