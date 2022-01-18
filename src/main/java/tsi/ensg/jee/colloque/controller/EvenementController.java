package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/createEvenForm")
    public String createEvenement(Model model) {
        model.addAttribute("evenement", new Evenement()); // Ajout au modèle
        return "createEvenForm";
    }

    @PostMapping("/createEvenForm")
    public String addEvenement(Model model, @ModelAttribute("evenement") Evenement evenement) {
        model.addAttribute("evenement", evenement);
        evenementDao.save(evenement);
        return "redirect:/evenements";
    }

    @GetMapping("/evenements")
    public String getEvenements(Model model) {
        model.addAttribute("evenements", evenementDao.findAll()); // Ajout au modèle
        return "evenements"; //Envoi vers la vue
    }

    @PutMapping("/evenement/{num_even}")
    public String updateEvenement(Model model, @PathVariable Long num_even) {return "evenement";} //Envoi vers la vue

    @DeleteMapping("/evenement/{num_even}")
    public String deleteEvenement(Model model, @PathVariable Long num_even) {return "evenement";} //Envoi vers la vue*/
}
