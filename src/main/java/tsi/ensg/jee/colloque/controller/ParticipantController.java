package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    int nbMaxParticipant = 5;

    @GetMapping("/participant")
    public String create(Model model) {
        Participant participant = new Participant("Boby", "Lapointe",
                "boby.lapointe@jgv.com", "10/01/1975",
                "ENSG", "...");
        participantDao.save(participant);
        model.addAttribute("participant", participant); // Ajout au modèle
        return "participant";
    }

    @GetMapping("/participant/{numPerson}")
    public String getParticipant(Model model, @PathVariable Long numPerson) {
        if (participantDao.findById(numPerson).isPresent()){
            Participant participant = participantDao.findById(numPerson).get();
            model.addAttribute("participant", participant); // Ajout au modèle
        }
        return "participant"; //Envoi vers la vue
    }

    @GetMapping("/participants")
    public String getParticipants(Model model) {
        model.addAttribute("participants",participantDao.findAll()); // Ajout au modèle
        return "participants"; //Envoi vers la vue
    }

    @GetMapping("/createPartForm")
    public String createParticipant(Model model) {
        model.addAttribute("nbMaxParticipant", nbMaxParticipant);
        model.addAttribute("participants",participantDao.findAll()); // Ajout au modèle
        model.addAttribute("participant", new Participant()); // Ajout au modèle
        return "createPartForm";
    }

    @PostMapping("/createPartForm")
    public String addParticipant(Model model, @ModelAttribute("participant") Participant participant) {
        model.addAttribute("participant", participant);
        participantDao.save(participant);
        return "redirect:/participants";
    }

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
    public String deleteEvenement(Model model, @PathVariable("numPerson") Long numPerson) {
        Participant participant = participantDao.findById(numPerson).get();
        System.out.println("test");
        participantDao.delete(participant);
        return "redirect:/participants";
    } //Envoi vers la vue

}
