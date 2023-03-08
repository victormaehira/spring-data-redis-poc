package br.com.victor.service;

import br.com.victor.controller.exceptions.EntityNotFoundException;
import br.com.victor.model.Cidadao;
import br.com.victor.repository.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadaoService {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @Cacheable(cacheNames = Cidadao.CACHE_NAME, key="#root.method.name")
    public List<Cidadao> findAll() {
        return cidadaoRepository.findAll();
    }

    @Cacheable(cacheNames = Cidadao.CACHE_NAME, key="#idn")
    public Cidadao findbyIdn(final String idn) {
        return cidadaoRepository.findById(idn)
                .orElseThrow(() -> new EntityNotFoundException("Idn not found: " + idn));
    }

    @CacheEvict(cacheNames = Cidadao.CACHE_NAME, allEntries = true)
    public Cidadao create(final Cidadao cidadao) {
        return cidadaoRepository.save(cidadao);
    }

    @CachePut(cacheNames = Cidadao.CACHE_NAME, key="#cidadao.idn()")
    public Cidadao update(final Cidadao cidadao) {
        if(cidadao.getIdn() == null) {
            throw new EntityNotFoundException("Idn nao encontrado");
        }

        return cidadaoRepository.save(cidadao);
    }

    @CacheEvict(cacheNames = Cidadao.CACHE_NAME, key="#idn")
    public void delete(final String idn) {
        if(idn == null) {
            System.out.println("IDN NAO ENCONTRADO");
            throw new EntityNotFoundException("Idn nulo");
        }

        cidadaoRepository.deleteById(idn);
    }
}
