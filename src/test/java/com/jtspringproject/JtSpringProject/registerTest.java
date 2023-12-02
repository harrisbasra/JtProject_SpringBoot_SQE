package com.jtspringproject.JtSpringProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class registerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidRegistration() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "validPassword")
                        .param("email", "validemail@example.com")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("success")); // Replace "success" with the actual success view
    }

    @Test
    public void testInvalidEmailFormat() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "validPassword")
                        .param("email", "invalidemail")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testShortPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "short")
                        .param("email", "validemail@example.com")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testEmptyFields() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testEmptyUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "")
                        .param("password", "validPassword")
                        .param("email", "validemail@example.com")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testEmptyPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "")
                        .param("email", "validemail@example.com")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testEmptyEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "validPassword")
                        .param("email", "")
                        .param("address", "Valid Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")); // Replace "register" with the actual register view for errors
    }

    @Test
    public void testEmptyAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newuserregister")
                        .param("username", "validUsername")
                        .param("password", "validPassword")
                        .param("email", "validemail@example.com")
                        .param("address", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register")) // Replace "register" with the actual register view for errors
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("addressError")); // Ensure that no address error is present
    }

}
