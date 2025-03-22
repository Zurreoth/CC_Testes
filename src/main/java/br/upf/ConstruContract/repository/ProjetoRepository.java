package br.upf.ConstruContract.repository;

import br.upf.ConstruContract.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
