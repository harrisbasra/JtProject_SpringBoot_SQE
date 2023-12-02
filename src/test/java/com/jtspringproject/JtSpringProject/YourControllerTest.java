package com.jtspringproject.JtSpringProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class YourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorrectUsernameAndPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userloginvalidate")
                        .param("username", "lisa")
                        .param("password", "765"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("success")); // Replace "success" with the actual success view
    }

    @Test
    public void testCorrectUsernameIncorrectPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userloginvalidate")
                        .param("username", "lisa")
                        .param("password", "test1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login")); // Replace "login" with the actual login view
    }

    @Test
    public void testIncorrectUsernameCorrectPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userloginvalidate")
                        .param("username", "test2")
                        .param("password", "765"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login")); // Replace "login" with the actual login view
    }

    @Test
    public void testIncorrectUsernameAndPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userloginvalidate")
                        .param("username", "test2")
                        .param("password", "test1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login")); // Replace "login" with the actual login view
    }
    
}
