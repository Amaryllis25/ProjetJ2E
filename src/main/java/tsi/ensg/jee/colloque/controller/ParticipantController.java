package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

import javax.validation.Valid;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    /**
     * Function which get a participant
     * @param model the view
     * @param numPerson the id of the participant
     * @return View participant.html
     */
    @GetMapping("/participant/{numPerson}")
    public String getParticipant(Model model, @PathVariable Long numPerson) {
        if (participantDao.findById(numPerson).isPresent()){
            Participant participant = participantDao.findById(numPerson).get();
            model.addAttribute("participant", participant); // Ajout au modèle
        }
        return "participant"; //Envoi vers la vue
    }

    /**
     * Function which get all participants
     * @param model the view
     * @return View participants.html
     */
    @GetMapping("/participants")
    public String getParticipants(Model model) {
        model.addAttribute("participants",participantDao.findAll()); // Ajout au modèle
        return "participants"; //Envoi vers la vue
    }

    /**
     * Function which recover informations about a participant
     * @param model the view
     * @return View createPartForm.html
     */
    @GetMapping("/createPartForm")
    public String createParticipant(Model model) {
        model.addAttribute("participants",participantDao.findAll()); // Ajout au modèle
        model.addAttribute("participant", new Participant()); // Ajout au modèle
        return "createPartForm";
    }

    /**
     * Function which add a new participant to table participant
     * @param model the view
     * @param participant the participant
     * @param bindingResult bind error to result
     * @return View createPartForm.html
     */
    @PostMapping("/createPartForm")
    public String addParticipant(Model model, @Valid @ModelAttribute("participant") Participant participant, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createPartForm";
        }

        model.addAttribute("participants", participantDao.findAll());
        model.addAttribute("participant", participant);
        participantDao.save(participant);
        return "redirect:/participants";
    }

    /**
     * Function which edit a participant to participant
     * @param model the view
     * @param numPerson the id of the participant
     * @return View createPartForm.html
     */
    @GetMapping("/editParticipant/{numPerson}")
    public String editParticipant(Model model, @PathVariable("numPerson") Long numPerson) {
        Participant participant = participantDao.findById(numPerson).get();

        model.addAttribute("participant", participant);
        return "createPartForm";
    }

    /**
     * Function which delete a participant to participants.html
     * @param model the view
     * @param numPerson the id of the participant
     * @return View participants.html
     */
    @GetMapping("/deletePart/{numPerson}")
    public String deleteParticipant(Model model, @PathVariable("numPerson") Long numPerson) {
        Participant participant = participantDao.findById(numPerson).get();
        participantDao.delete(participant);
        return "redirect:/participants";
    } //Envoi vers la vue

}
