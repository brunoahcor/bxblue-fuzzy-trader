package br.com.bxblue.fuzzytrader.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bxblue.fuzzytrader.model.entity.Carteira;
import br.com.bxblue.fuzzytrader.model.entity.Cliente;

@Repository
public interface CarteiraRespository extends CrudRepository<Carteira,Long> {

    Optional<Carteira> findByCliente(Cliente cliente);
    
}