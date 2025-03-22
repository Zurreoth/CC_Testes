package br.upf.ConstruContract;

import br.upf.ConstruContract.controller.ContratoController;
import br.upf.ConstruContract.controller.ProjetoController;
import br.upf.ConstruContract.dto.ContratoDTO;
import br.upf.ConstruContract.dto.ProjetoDTO;
import br.upf.ConstruContract.model.*;
import br.upf.ConstruContract.service.ContratoService;
import br.upf.ConstruContract.service.ProjetoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({ContratoController.class, ProjetoController.class})
class ContratoControllerProjetoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContratoService contratoService;

    @MockBean
    private ProjetoService projetoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testContratoAndProjeto() throws Exception {
        ProjetoDTO projetoDTO = new ProjetoDTO("Projeto Integrado", 3000.0);
        Projeto projeto = new Projeto("Projeto Integrado", 3000.0);

        mockMvc.perform(post("/projeto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projetoDTO)))
                .andExpect(status().isOk());

        ContratoDTO contratoDTO = new ContratoDTO(new Date(), 3000.0, 1, null, null, List.of(projeto));
        Contrato contrato = new Contrato(new Date(), 3000.0, 1, null, null);
        contrato.setProjetos(Arrays.asList(new ProjetoContrato(projeto, contrato)));
        when(contratoService.getContratos()).thenReturn(Arrays.asList(contrato));

        mockMvc.perform(post("/contrato")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contratoDTO)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/contrato"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].valor").value(3000.0))
                .andExpect(jsonPath("$[0].projetos.size()").value(1))
                .andExpect(jsonPath("$[0].projetos[0].projeto.nome").value("Projeto Integrado"));

    }
}
