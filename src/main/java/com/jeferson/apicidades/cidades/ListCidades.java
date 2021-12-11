package com.jeferson.apicidades.cidades;

import com.jeferson.apicidades.servico.CauculaDistancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jeferson
 * @version v1.0
 * @see Cidade
 * @see CauculaDistancia
 */
@RestController
@RequestMapping("/")
public class ListCidades {
    @Autowired
    RepositorioCidade repositorioCidade;

    /**
     *
     * @param page Paginação
     * @return Lista todas as cidades
     */
    @GetMapping
    public Page<Cidade> listCidade(Pageable page){return repositorioCidade.findAll(page);}

    /**
     *
     * @param origem Nome da cidade de origme
     * @param destino Nome da cidade de destino
     * @return Dados de localização e distancia em linha reta
     */
    @GetMapping("/distancia")
    public Map<String,Double> listCidadePorNome(@RequestParam("origem") String origem, @RequestParam("destino") String destino){
        double latOrigem = 0.0;
        double lonOrigem = 0.0;
        double latDestino = 0.0;
        double lonDestino = 0.0;
        String  localizacao = "";
        List<Cidade> geolocalizacao = repositorioCidade.rota(origem,destino);

        for (Cidade c:geolocalizacao) {
            if(origem.equals(c.getNome())){
                 localizacao = c.getLocalizacao().replace("(","").replace(")","");
                 String[] ponto = localizacao.split(",");

                 latOrigem = Double.parseDouble(ponto[0]);
                 lonOrigem = Double.parseDouble(ponto[1]);

            }else if(destino.equals(c.getNome())){
                localizacao = c.getLocalizacao().replace("(","").replace(")","");
                String[] ponto = localizacao.split(",");

                latDestino = Double.parseDouble(ponto[0]);
                lonDestino = Double.parseDouble(ponto[1]);
            }
        }
        double distancia = CauculaDistancia.distanceKM(latOrigem,lonOrigem,latDestino,lonDestino);
        Map<String,Double> dados = new HashMap<>();
        dados.put("distanciaKM", distancia);
        dados.put("latitudeOrigem",latOrigem);
        dados.put("longitudeOrigem",lonOrigem);
        dados.put("latitudeDestino",latDestino);
        dados.put("longitudeDestino",lonDestino);
        return dados;
    }

}
