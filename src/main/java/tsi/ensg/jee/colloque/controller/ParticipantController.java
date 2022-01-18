package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.services.ParticipantDao;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantDao participantDao;

    @GetMapping("/participants")
    public String getParticipants(Model model) {
        model.addAttribute("participants",participantDao.findAll()); // Ajout au modèle
        return "participants"; //Envoi vers la vue
    }

    @GetMapping("/createPartForm")
    public String createParticipant(Model model) {
        //https://www.baeldung.com/thymeleaf-list
        ParticipantDao partForm = new ParticipantDao();

        //Participant part= new Participant("CMA", "Alla", "@", "06/12/99", "a", "b");

        partForm.save(new Participant());

        model.addAttribute("form", partForm);
        return "createPartForm"; //Envoi vers la vue
    }

    @PostMapping("/participants")
    public String saveParticipant(@ModelAttribute ParticipantDao form, Model model) {
        //participantDao.save(form.findAll());
        model.addAttribute("participants", participantDao.findAll());
        return "redirect:/participants";
    }
}
