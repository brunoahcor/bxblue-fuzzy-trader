package br.com.bxblue.fuzzytrader.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bxblue.fuzzytrader.converter.Converter;
import br.com.bxblue.fuzzytrader.model.entity.Carteira;
import br.com.bxblue.fuzzytrader.model.entity.Cliente;
import br.com.bxblue.fuzzytrader.model.entity.ItemCarteira;
import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.model.vo.CarteiraVo;
import br.com.bxblue.fuzzytrader.model.vo.ItemCarteiraVo;
import br.com.bxblue.fuzzytrader.model.vo.NovaCarteiraVo;
import br.com.bxblue.fuzzytrader.repository.CarteiraRespository;
import br.com.bxblue.fuzzytrader.repository.ItemCarteiraRespository;

@Service
public class CarteiraService implements ICarteiraService {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IAtivoService ativoService;

    @Autowired
    private ItemCarteiraRespository itemRepository;

    @Autowired
    private CarteiraRespository repository;

    @Autowired
    private Converter converter;

    @Override
    public CarteiraVo buscarPorId(Long id){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        Optional<Carteira> carteira = repository.findByCliente(cliente);
        return carteira.isPresent() ? converter.toVO(carteira.get()) : null;
    }

    @Override
    public CarteiraVo salvar(NovaCarteiraVo novaCarteiraVo) {

        CarteiraVo vo = new CarteiraVo();
        populaCarteiraVo(novaCarteiraVo, vo);

        Carteira carteira = new Carteira();
        carteira.setCliente( converter.toEntity(vo.getCliente()) );
        
        List<ItemCarteira> itens = new ArrayList<>();
        carteira.setItens(itens);
        for (ItemCarteiraVo itensVo : vo.getItens()) {

            itensVo.setValorCompra( itensVo.getAtivo().getValor() );

            BigDecimal cotas = itensVo.getValorTotal().divide( itensVo.getValorCompra(),2,RoundingMode.HALF_UP);
            itensVo.setCotas(  cotas.doubleValue() );

            ItemCarteira item = converter.toEntity( itensVo );
            item.setCarteira(carteira);
            itens.add( item );
        }

        carteira.setValorTotal( somaValorTotalItens(itens) );
        
        repository.save(carteira);

        return converter.toVO(carteira);
    }

    private BigDecimal somaValorTotalItens(List<ItemCarteira> itens){
        return itens.stream().map(ItemCarteira::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void populaCarteiraVo(NovaCarteiraVo novaCarteiraVo, CarteiraVo carteiraVo) {

        carteiraVo.setCliente( clienteService.buscarPorCpf(novaCarteiraVo.getClienteCpf()) );

        List<ItemCarteiraVo> itens = new ArrayList<>();
        for (String simbolo : novaCarteiraVo.getAtivosSimbolo()) {
            AtivoVo ativoVo = ativoService.buscarPorSimbolo(simbolo);
            ItemCarteiraVo itemVo = new ItemCarteiraVo();
            itemVo.setAtivo(ativoVo);
            itemVo.setValorTotal(novaCarteiraVo.getValorInvestimento());
            itens.add(itemVo);
        }

        carteiraVo.setItens(itens);
    }
    
}