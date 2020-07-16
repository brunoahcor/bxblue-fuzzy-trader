package br.com.bxblue.fuzzytrader.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bxblue.fuzzytrader.model.entity.ItemCarteira;

@Repository
public interface ItemCarteiraRespository extends CrudRepository<ItemCarteira,Long> {
    
}