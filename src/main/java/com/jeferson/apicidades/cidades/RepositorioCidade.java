package com.jeferson.apicidades.cidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioCidade extends JpaRepository<Cidade, Long> {
    @Query(value = "select c from Cidade c where c.nome in(?1,?2)")
    List<Cidade> rota(String origem, String destino);
}
