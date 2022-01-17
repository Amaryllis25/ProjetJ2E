package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.IntervenantDao;

@Controller
public class IntervenantController {

    @Autowired
    IntervenantDao intervenantDao;

    @GetMapping("/intervenants")
    public String getIntervant(Model model) {
        return "intervenant"; //Envoi vers la vue
    }
}
