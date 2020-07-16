package br.com.bxblue.fuzzytrader.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;

public interface IAtivoService {

    List<AtivoVo> listarTodosAtivos();

    List<AtivoVo> listarAtivosPorValor(BigDecimal valor);

    AtivoVo salvar(AtivoVo vo);

    List<AtivoVo> listar();

    AtivoVo buscarPorSimbolo(String simbolo);
    
}