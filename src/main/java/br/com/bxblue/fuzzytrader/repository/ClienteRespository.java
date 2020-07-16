package br.com.bxblue.fuzzytrader.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bxblue.fuzzytrader.model.entity.Cliente;

@Repository
public interface ClienteRespository extends CrudRepository<Cliente,Long> {

    List<Cliente> findAll();

    Optional<Cliente> findByCpf(String cpf);
    
}