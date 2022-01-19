package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.services.EvenementDao;

@Controller
public class EvenementController {

    @Autowired
    EvenementDao evenementDao;

    /**
     * Function which get all events
     * @param model the view
     * @return View evenement.html
     */
    @GetMapping("/evenements")
    public String getEvenements(Model model) {
        model.addAttribute("evenements", evenementDao.findAll()); // Ajout au modèle
        return "evenements"; //Envoi vers la vue
    }

    /**
     * Function which get a event with its id
     * @param model the view
     * @param numEvent the id of the event
     * @return View evenement.html
     */
    @GetMapping("/evenement/{numEvent}")
    public String getEvenement(Model model, @PathVariable Long numEvent) {
        if (evenementDao.findById(numEvent).isPresent()){
            Evenement evenement = evenementDao.findById(numEvent).get();
            model.addAttribute("evenement", evenement); // Ajout au modèle
        }
        return "evenement"; //Envoi vers la vue
    }

    /**
     * Function which get a event with its id
     * @param model the view
     * @return View createEvenForm.html
     */
    @GetMapping("/createEvenForm")
    public String createEvenement(Model model) {
        model.addAttribute("evenement", new Evenement()); // Ajout au modèle
        return "createEvenForm";
    }

    /**
     * Function which send data event to evenements.html
     * @param model the view
     * @param evenement event to add
     * @return View evenements.html
     */
    @PostMapping("/createEvenForm")
    public String addEvenement(Model model, @ModelAttribute("evenement") Evenement evenement) {
        model.addAttribute("evenement", evenement);
        evenementDao.save(evenement);
        return "redirect:/evenements";
    }

    /**
     * Function which delete an event to evenements.html
     * @param model the view
     * @param numEvent the id of the event
     * @return View evenements.html
     */
    @GetMapping("/deleteEvent/{numEvent}")
    public String deleteEvenement(Model model, @PathVariable("numEvent") Long numEvent) {
        Evenement evenement = evenementDao.findById(numEvent).get();
        System.out.println("test");
        evenementDao.delete(evenement);
        return "redirect:/evenements";
    } //Envoi vers la vue

    /**
     * Function which update an event to evenement.html
     * @param model the view
     * @return View evenement.html
     */
    @PutMapping("/evenementUpdate/{numEvent}")
    public String updateEvenement(Model model, @PathVariable Long numEvent) {return "evenement";} //Envoi vers la vue
}
