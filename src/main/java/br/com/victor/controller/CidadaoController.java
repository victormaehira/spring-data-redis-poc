package br.com.victor.controller;

import br.com.victor.model.Cidadao;
import br.com.victor.service.CidadaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {

    @Autowired
    private CidadaoService cidadaoService;

    @GetMapping
    public List<Cidadao> findAll() {
        return cidadaoService.findAll();
    }

    @GetMapping("/{idn}")
    public Cidadao findByIdn(@PathVariable("idn") final String idn) {
        return cidadaoService.findbyIdn(idn);
    }

    @PostMapping
    public Cidadao create(@RequestBody final Cidadao cidadao) {
        return cidadaoService.create(cidadao);
    }

    @PutMapping
    public Cidadao update(@RequestBody final Cidadao cidadao) {
        return cidadaoService.update(cidadao);
    }

    @DeleteMapping("/{idn}")
    public void delete(@PathVariable("idn") final String idn) {
        cidadaoService.delete(idn);
    }

}
