package br.com.bxblue.fuzzytrader.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bxblue.fuzzytrader.model.entity.Ativo;

@Repository
public interface AtivoRepository extends CrudRepository<Ativo,Long>  {

    List<Ativo> findAll();

    Optional<Ativo> findBySimbolo(String simbolo);
    
}