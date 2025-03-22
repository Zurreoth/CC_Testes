package br.upf.ConstruContract;

import br.upf.ConstruContract.model.*;
import br.upf.ConstruContract.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository,
                                   ContratanteRepository contratanteRepository,
                                   VendedorRepository vendedorRepository,
                                   AdminRepository adminRepository,
                                   ProjetoRepository projetoRepository,
                                   ContratoRepository contratoRepository) {

        return args -> {
            Usuario usuario = new Usuario("Teste1", "teste2");
            Usuario usuario2 = new Usuario("Teste2", "teste3");
            Usuario usuario3 = new Usuario("Teste3", "teste4");

            Contratante contratante = new Contratante(usuario);
            log.info("Preloading {}", contratanteRepository.save(contratante));

            Vendedor vendedor = new Vendedor(usuario2);
            log.info("Preloading {}", vendedorRepository.save(vendedor));

            log.info("Preloading {}", adminRepository.save(new Admin(usuario3)));

            Projeto projeto = new Projeto("PRoj1", 500.0);
            log.info("Preloading {}", projetoRepository.save(projeto));

            Contrato contrato = new Contrato(Date.from(Instant.now()), 500.0, 1, contratante, vendedor);
            contrato.setProjetos(Arrays.asList(new ProjetoContrato(projeto, contrato)));
            log.info("Preloading {}", contratoRepository.save(contrato));
        };
    }
}
