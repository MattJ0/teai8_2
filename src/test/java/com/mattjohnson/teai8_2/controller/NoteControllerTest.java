package com.mattjohnson.teai8_2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //com.mattjohnson.teai8_2.controller.NoteController#getNoteById()
    @Test
    void returnNoteById() throws Exception {
        mockMvc.perform(get("/api/notes/{id}", 39))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", is(equalTo("string"))));
    }

    @Test
    void notFoundRemovedNoteById() throws Exception {
        mockMvc.perform(get("/api/notes/{id}", 1))
                .andExpect(status().isNotFound());
    }

    //com.mattjohnson.teai8_2.controller.NoteController#getNotesByUserId()
    @Test
    void returnNotesByUserId() throws Exception {
        mockMvc.perform(get("/api/notes/userId/{id}", 7))
                .andExpect(status().isOk());
    }

    @Test
    void notFoundNotesByRemovedUserId() throws Exception {
        mockMvc.perform(get("/api/notes/userId/{id}", 1))
                .andExpect(status().isNotFound());
    }

    //com.mattjohnson.teai8_2.controller.NoteController#addNote()
    @Test
    void addingNoteForActiveUser() throws Exception {

        mockMvc.perform(post("/api/notes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"testMvc\", \"content\": \"testMvc\", \"userId\":7}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void notFoundRemovedUserWhileAddingNote() throws Exception {
        mockMvc.perform(post("/api/notes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"testMvc\", \"content\": \"testMvc\", \"userId\":2}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    //com.mattjohnson.teai8_2.controller.NoteController#updateNote()

    @Test
    void updateExistingNote() throws Exception {
        mockMvc.perform(put("/api/notes/{id}", 40)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"testUpdateMvc\", \"content\": \"testUpdateMvc\", \"userId\":7}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    //com.mattjohnson.teai8_2.controller.NoteController#deleteNote()

    @Test
    void deleteNoteById() throws Exception {
        mockMvc.perform(delete("/api/notes/{id}", 41))
                .andExpect(status().isOk());
    }


}
