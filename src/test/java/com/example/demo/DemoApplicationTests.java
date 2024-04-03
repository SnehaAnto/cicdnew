
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DoubleNumControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void doubleShouldReturnDefaultAnswer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/double"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(10));
    }

    @Test
    void doubleShouldReturnCustomValue() throws Exception {
        int customValue = 90;
        mockMvc.perform(MockMvcRequestBuilders.get("/double").param("value", String.valueOf(customValue)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(180)); // The result should be double of the custom value
    }
}
