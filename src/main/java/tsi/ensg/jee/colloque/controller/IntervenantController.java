package tsi.ensg.jee.colloque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tsi.ensg.jee.colloque.services.IntervenantDao;

@Controller
public class IntervenantController {

    @Autowired
    IntervenantDao intervenantDao;

}
