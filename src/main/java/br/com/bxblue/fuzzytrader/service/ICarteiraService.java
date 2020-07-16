package br.com.bxblue.fuzzytrader.service;

import br.com.bxblue.fuzzytrader.model.vo.CarteiraVo;
import br.com.bxblue.fuzzytrader.model.vo.NovaCarteiraVo;

public interface ICarteiraService {

    CarteiraVo buscarPorId(Long id);

    CarteiraVo salvar(NovaCarteiraVo novaCarteiraVo);
    
}