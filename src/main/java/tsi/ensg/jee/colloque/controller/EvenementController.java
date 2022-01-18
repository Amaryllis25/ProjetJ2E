package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.EvenementDao;

@Controller
public class EvenementController {

    @Autowired
    EvenementDao evenementDao;

    @GetMapping("/evenement")
    public String create(Model model) {
        Evenement evenement = new Evenement("Undertale party", "Undertale", "22/04/2022", 3,
                100000, "Events for Undertale's fans", "Toby Fox", "Trailer");
        evenementDao.save(evenement);
        model.addAttribute("evenement", evenement); // Ajout au modèle
        return "evenement";
    }

    @GetMapping("/evenement/{num_even}")
    public String getEvenement(Model model, @PathVariable Long num_even) {
        if (evenementDao.findById(num_even).isPresent()){
            Evenement evenement = evenementDao.findById(num_even).get();
            //participantDao.save(part);
            model.addAttribute("evenement", evenement); // Ajout au modèle
        }
        return "evenement"; //Envoi vers la vue
    }
}
