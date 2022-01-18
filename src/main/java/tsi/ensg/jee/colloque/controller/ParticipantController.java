package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    @GetMapping("/participant")
    public String create(Model model) {
        Participant participant = new Participant("Boby", "Lapointe",
                "boby.lapointe@jgv.com", "10/01/1975",
                "ENSG", "...");
        participantDao.save(participant);
        model.addAttribute("participant", participant); // Ajout au modèle
        return "participant";
    }

    @GetMapping("/participant/{num_person}")
    public String getParticipant(Model model, @PathVariable Long num_person) {
        if (participantDao.findById(num_person).isPresent()){
            Participant participant = participantDao.findById(num_person).get();
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
        model.addAttribute("participant", new Participant()); // Ajout au modèle
        return "createPartForm";
    }

    @PostMapping("/createPartForm")
    public String addParticipant(Model model, @ModelAttribute("participant") Participant participant) {
        model.addAttribute("participant", participant);
        participantDao.save(participant);
        return "redirect:/participants";
    }

    @PostMapping("/editParticipant")
    public String editParticipant(Model model, Participant participant) {
        model.addAttribute("participant", participant);
        return "editParticipant";
    }

    @PutMapping("/participant/{num_person}")
    public String updateParticipant(Model model, @PathVariable Long num_person) {return "editParticipant";} //Envoi vers la vue

    @DeleteMapping("/participant/{num_person}")
    public String deleteParticipant(Model model, @PathVariable Long num_person) {return "participants";} //Envoi vers la vue
}
