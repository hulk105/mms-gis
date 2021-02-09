package ua.nure.informationgismodels.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.nure.informationgismodels.dao.GisRepository;
import ua.nure.informationgismodels.entity.Gis;
import ua.nure.informationgismodels.entity.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.nure.informationgismodels.util.JsonConverter.asJsonString;
import static ua.nure.informationgismodels.util.JsonConverter.jsonToObject;

@SpringBootTest
@AutoConfigureMockMvc
class GisControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GisRepository gisRepository;
    private Gis testGis;

    @BeforeEach
    void setUp() {
        testGis = new Gis(0, new Point(1, 1), 2, 2, 10, "Station");
    }

    @AfterEach
    void tierDown() {
        gisRepository.deleteAll();
    }

    @Test
    void findAll_shouldReturnAllDbContent() throws Exception {
        assertEquals(0, gisRepository.count());
        Gis gisFromDB = gisRepository.save(testGis);

        MvcResult mvcResult = mockMvc.perform(get("/gis/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        Gis[] gis = jsonToObject(json, Gis[].class);
        assertEquals(1, gis.length);
        assertEquals(gisFromDB, gis[0]);
    }

    @Test
    void get_shouldFindById() throws Exception {
        long id = gisRepository.save(testGis).getId();
        assertEquals(1, gisRepository.count());

        mockMvc.perform(get("/gis/{id}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tag").value("Station"));
        assertEquals(1, gisRepository.count());
    }

    @Test
    void create_shouldCreateValidGis() throws Exception {
        mockMvc.perform(post("/gis")
                .content(asJsonString(testGis))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
        assertEquals(1, gisRepository.count());
    }

    @Test
    void update_shouldUpdateExisted() throws Exception {
        assertEquals(0, gisRepository.count());
        Gis gisFromDB = gisRepository.save(testGis);
        gisFromDB.setTag("City");

        mockMvc.perform(put("/gis")
                .content(asJsonString(gisFromDB))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.tag").value("City"));
        assertEquals(1, gisRepository.count());
    }

    @Test
    void delete_shouldDeleteExistEntity() throws Exception {
        long id = gisRepository.save(testGis).getId();
        assertEquals(1, gisRepository.count());

        mockMvc.perform(delete("/gis/{id}", id))
                .andExpect(status().isNoContent());
        assertEquals(0, gisRepository.count());
    }
}