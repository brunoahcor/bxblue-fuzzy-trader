package br.com.bxblue.fuzzytrader.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bxblue.fuzzytrader.converter.Converter;
import br.com.bxblue.fuzzytrader.model.entity.Ativo;
import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.repository.AtivoRepository;

@Service
public class AtivoService implements IAtivoService {

    @Autowired
    private IAtivoServiceConsumer consumer;

    @Autowired
    private AtivoRepository repository;

    @Autowired
    private Converter converter;

    @Override
    public List<AtivoVo> listarTodosAtivos() {
        return consumer.obterDadosMaisRecentesAtivos().stream()
                       .sorted(Comparator.comparing(AtivoVo::getValor))
                       .collect(Collectors.toList());
    }

    @Override
    public List<AtivoVo> listarAtivosPorValor(BigDecimal valor) {
        return consumer.obterDadosMaisRecentesAtivos().stream()
                       .sorted(Comparator.comparing(AtivoVo::getValor))
                       .filter( x -> x.getValor().compareTo(valor) == -1 )
                       .collect(Collectors.toList());
    }

    @Override
    public AtivoVo salvar(AtivoVo vo) {
        Ativo ativo = repository.save( converter.toEntity(vo) );
        return converter.toVO(ativo);
    }

    @Override
    public List<AtivoVo> listar() {
        List<Ativo> ativos = repository.findAll();
        return converter.toListAtivoVo(ativos);
    }

    @Override
    public AtivoVo buscarPorSimbolo(String simbolo) {
        Optional<Ativo> ativo = repository.findBySimbolo(simbolo);
        return ativo.isPresent() ? converter.toVO(ativo.get()) : null;
    }
    
}