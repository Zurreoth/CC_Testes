package br.upf.ConstruContract.repository;

import br.upf.ConstruContract.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
