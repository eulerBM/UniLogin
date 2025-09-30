package com.login.back_end.controller;

import com.login.back_end.facebook.FacebookController;
import com.login.back_end.facebook.FacebookService;
import com.login.back_end.github.GithubController;
import com.login.back_end.github.GithubService;
import com.login.back_end.google.GoogleController;
import com.login.back_end.google.GoogleService;
import com.login.back_end.linkedin.LinkedinController;
import com.login.back_end.linkedin.LinkedinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({FacebookController.class, GithubController.class, GoogleController.class, LinkedinController.class})
@AutoConfigureMockMvc(addFilters = false) // remove filtros de segurança
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FacebookService facebookService;
    @MockitoBean
    private GithubService githubService;
    @MockitoBean
    private GoogleService googleService;
    @MockitoBean
    private LinkedinService linkedinService;


    @Test
    @DisplayName("Deve retornar OK na rota do facebook")
    void shouldReturnOkWhenGoingOnFacebookRoute() throws Exception {

        given(facebookService.facebookHello())
                .willAnswer(invocation -> ResponseEntity.ok("Hello Facebook"));

        mockMvc.perform(get("/facebook"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Facebook"));

    }

    @Test
    @DisplayName("Deve retornar OK na rota do github")
    void shouldReturnOkWhenGoingOnGithubRoute() throws Exception {

        given(githubService.githubHello())
                .willAnswer(invocation -> ResponseEntity.ok("Hello Github"));

        mockMvc.perform(get("/github"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Github"));
    }

    @Test
    @DisplayName("Deve retornar OK na rota do google")
    void shouldReturnOkWhenGoingOnGoogleRoute() throws Exception {

        given(googleService.googleHello())
                .willAnswer(invocation -> ResponseEntity.ok("Hello Google"));

        mockMvc.perform(get("/google"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Google"));
    }

    @Test
    @DisplayName("Deve retornar OK na rota do linkedin")
    void shouldReturnOkWhenGoingOnLinkedinRoute() throws Exception {
        given(linkedinService.linkedinHello())
                .willAnswer(invocation -> ResponseEntity.ok("Hello Linkedin"));

        mockMvc.perform(get("/linkedin"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Linkedin"));

    }
}
