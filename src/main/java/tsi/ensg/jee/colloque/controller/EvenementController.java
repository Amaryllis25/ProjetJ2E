package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.EvenementDao;
import tsi.ensg.jee.colloque.services.ParticipantDao;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EvenementController {

    @Autowired
    EvenementDao evenementDao;

    @Autowired
    ParticipantDao participantDao;

    /**
     * Function which get all events
     * @param model the view
     * @return View evenement.html
     */
    @GetMapping("/evenements")
    public String getEvenements(Model model) {
        model.addAttribute("evenements", evenementDao.findAll()); // Ajout au modèle
        model.addAttribute("participants", participantDao.findAll());
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
            model.addAttribute("participants", participantDao.findAll());
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
    public String addEvenement(Model model, @Valid @ModelAttribute("evenement") Evenement evenement, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createEvenForm";
        }
        model.addAttribute("evenement", evenement);
        if(evenement.getParticipants().isEmpty()) {
            List<Participant> participants = new ArrayList<>();
            evenement.setParticipants(participants);
        }else{
            List<Participant> participants = evenement.getParticipants();
            evenement.setParticipants(participants);
        }
        evenementDao.save(evenement);
        return "redirect:/evenements";
    }

    /**
     * Function which update an event to evenement.html
     * @param model the view
     * @return View evenement.html
     */
    @GetMapping("/editEvenement/{numEvent}")
    public String editEvenement(Model model, @PathVariable("numEvent") Long numEvent) {
        Evenement evenement = evenementDao.findById(numEvent).get();
        model.addAttribute("evenement", evenement);
        return "createEvenForm";
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
        evenementDao.delete(evenement);
        return "redirect:/evenements";
    } //Envoi vers la vu

    /**
     * Function which add a participant to evenement
     * @param model the view
     * @param numEvent the id of the event
     * @param numPerson the id of the participant
     * @return View evenement.html
     */
    @GetMapping("/evenement/{numEvent}/add/{numPerson}")
    public String addParticipant(Model model, @PathVariable("numEvent") Long numEvent, @PathVariable("numPerson") Long numPerson) {

        Evenement evenement = evenementDao.findById(numEvent).get();

        if (evenement.getParticipants().size() < evenement.getNbPartMax()) {
            Participant participant = participantDao.findById(numPerson).get();
            if (evenement.getParticipants().contains(participant)) {
                return "redirect:/evenement/" + numEvent;
            } else {
                evenement.addParticipant(participant);
                model.addAttribute("evenement", evenement);
                evenementDao.save(evenement);
            }
        }
            return "redirect:/evenement/" + numEvent;
    }

    /**
     * Function which suppress a participant to evenement
     * @param model the view
     * @param numEvent the id of the event
     * @param numPerson the id of the participant
     * @return View evenement.html
     */
    @GetMapping("/evenement/{numEvent}/supp/{numPerson}")
    public String suppParticipant(Model model, @PathVariable("numEvent") Long numEvent, @PathVariable("numPerson") Long numPerson) {

        Evenement evenement = evenementDao.findById(numEvent).get();

        Participant participant = participantDao.findById(numPerson).get();
        evenement.suppParticipant(participant);
        model.addAttribute("evenement", evenement);
        evenementDao.save(evenement);
        return "redirect:/evenement/" + numEvent;
    }
}
