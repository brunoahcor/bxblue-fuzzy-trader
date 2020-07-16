package br.com.bxblue.fuzzytrader.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bxblue.fuzzytrader.converter.Converter;
import br.com.bxblue.fuzzytrader.model.entity.Cliente;
import br.com.bxblue.fuzzytrader.model.vo.ClienteVo;
import br.com.bxblue.fuzzytrader.repository.ClienteRespository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRespository repository;

    @Autowired
    private Converter converter;

    @Override
    public List<ClienteVo> listar() {
        List<Cliente> clientes = repository.findAll();
        return converter.toListClienteVo(clientes);
    }

    @Override
    public ClienteVo buscarPorCpf(String cpf){
        Optional<Cliente> cliente = repository.findByCpf(cpf);
        return cliente.isPresent() ? converter.toVO(cliente.get()) : null;
    }
    
}