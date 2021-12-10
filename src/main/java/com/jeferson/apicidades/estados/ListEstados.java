package com.jeferson.apicidades.estados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estados")
public class ListEstados{
    @Autowired
    RepositorioEstados repositorioEstados;
    @GetMapping
    public Page<Estados> listaEstados(Pageable page){return repositorioEstados.findAll(page);}
}
