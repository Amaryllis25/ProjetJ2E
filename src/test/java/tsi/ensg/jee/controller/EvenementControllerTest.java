package tsi.ensg.jee.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import tsi.ensg.jee.colloque.Application;
import tsi.ensg.jee.colloque.controller.EvenementController;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EvenementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEvenements() throws Exception {
        mockMvc.perform(get("/evenements"))
                .andExpect(status().isMovedTemporarily());
    }

}
