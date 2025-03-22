package br.upf.ConstruContract;

import br.upf.ConstruContract.controller.ContratoController;
import br.upf.ConstruContract.dto.ContratoDTO;
import br.upf.ConstruContract.model.*;
import br.upf.ConstruContract.service.ContratoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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

@WebMvcTest(ContratoController.class)
class ContratoControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ContratoService contratoService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetContratoes() throws Exception {
		List<Contrato> contratos = Arrays.asList(
				new Contrato(new Date(), 100.00, 1, null, null),
				new Contrato(new Date(), 200.00, 1, null, null)
		);

		when(contratoService.getContratos()).thenReturn(contratos);

		mockMvc.perform(get("/contrato"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].valor").value(100.00))
				.andExpect(jsonPath("$[0].status").value(1))
				.andExpect(jsonPath("$[1].valor").value(200.00))
				.andExpect(jsonPath("$[1].status").value(1));

		verify(contratoService, times(1)).getContratos();
	}

	@Test
	void testCadastrarContrato() throws Exception {
		ContratoDTO contratoDTO = new ContratoDTO(new Date(), 3000.0, 1, null, null);

		mockMvc.perform(post("/contrato")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(contratoDTO)))
				.andExpect(status().isOk());

		verify(contratoService, times(1)).cadastrarContrato(contratoDTO);
	}

	@Test
	void testExcluirContrato() throws Exception {
		Long contratoId = 1L;

		mockMvc.perform(delete("/contrato/{contratoId}", contratoId))
				.andExpect(status().isOk());

		verify(contratoService, times(1)).excluirContrato(contratoId);
	}

	@Test
	void testEditarContrato() throws Exception {
		Long contratoId = 1L;
		ContratoDTO contratoDTO = new ContratoDTO(new Date(), 3333.0, 1, null, null);

		mockMvc.perform(put("/contrato/{contratoId}", contratoId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(contratoDTO)))
				.andExpect(status().isOk());

		verify(contratoService, times(1)).editarContrato(contratoId, contratoDTO);
	}
}
