package br.com.bxblue.fuzzytrader.service;

import java.util.List;

import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;

public interface IAtivoServiceConsumer {

    List<AtivoVo> obterDadosMaisRecentesAtivos();
    
}