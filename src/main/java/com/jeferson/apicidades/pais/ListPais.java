package com.jeferson.apicidades.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Jeferson
 * @version v1.0
 */
@RestController
@RequestMapping("/pais")
public class ListPais {
    @Autowired
    private RepositorioPais repositorioPais;

    /**
     *
     * @param page Retorno da paginação
     * @return Lista de pais
     */
    @GetMapping
    public Page<Pais> todasAsCidades(Pageable page){
        return repositorioPais.findAll(page);
    }

    /**
     *
     * @param id ID do pais
     * @return Dados do pais referente ao ID
     */
    @GetMapping("/{id}")
    public ResponseEntity cidadePorId(@PathVariable Long id){
        Optional<Pais> optional = repositorioPais.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
