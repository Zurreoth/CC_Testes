package br.upf.ConstruContract.repository;

import br.upf.ConstruContract.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
