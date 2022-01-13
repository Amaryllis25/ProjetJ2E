package tsi.ensg.jee.colloque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tsi.ensg.jee.colloque.metier.Participant;

@Controller
public class ApplicationController {

    @GetMapping("/participants")
    public String getParticipant(Model model) {

        return "participant"; //Envoi vers la vue
    }
}
