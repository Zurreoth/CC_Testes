package br.upf.ConstruContract.repository;

import br.upf.ConstruContract.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
