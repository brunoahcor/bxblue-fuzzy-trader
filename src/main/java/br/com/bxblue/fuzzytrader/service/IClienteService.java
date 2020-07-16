package br.com.bxblue.fuzzytrader.service;

import java.util.List;

import br.com.bxblue.fuzzytrader.model.vo.ClienteVo;

public interface IClienteService {

    List<ClienteVo> listar();

    ClienteVo buscarPorCpf(String cpf);

}
