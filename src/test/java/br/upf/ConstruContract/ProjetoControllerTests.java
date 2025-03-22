package br.upf.ConstruContract;

import br.upf.ConstruContract.controller.ProjetoController;
import br.upf.ConstruContract.dto.ProjetoDTO;
import br.upf.ConstruContract.model.*;
import br.upf.ConstruContract.service.ProjetoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjetoController.class)
class ProjetoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjetoService projetoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetProjetos() throws Exception {
        Projeto projeto = new Projeto("Projeto 1", 500.0);
        when(projetoService.getProjetos()).thenReturn(List.of(projeto));

        mockMvc.perform(get("/projeto"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("Projeto 1"));

        verify(projetoService, times(1)).getProjetos();
    }

    @Test
    void testCadastrarProjeto() throws Exception {
        ProjetoDTO projetoDTO = new ProjetoDTO("Projeto 2", 1500.0);

        mockMvc.perform(post("/projeto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projetoDTO)))
                .andExpect(status().isOk());

        verify(projetoService, times(1)).cadastrarProjeto(projetoDTO);
    }
}
