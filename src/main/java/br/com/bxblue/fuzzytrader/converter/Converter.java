package br.com.bxblue.fuzzytrader.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bxblue.fuzzytrader.model.entity.Ativo;
import br.com.bxblue.fuzzytrader.model.entity.Carteira;
import br.com.bxblue.fuzzytrader.model.entity.Cliente;
import br.com.bxblue.fuzzytrader.model.entity.ItemCarteira;
import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.model.vo.CarteiraVo;
import br.com.bxblue.fuzzytrader.model.vo.ClienteVo;
import br.com.bxblue.fuzzytrader.model.vo.ItemCarteiraVo;

@Component
public class Converter {

    @Autowired
    private ModelMapper mm;

    // Cliente 
    // --------------------------------------------------
    public ClienteVo toVO(Cliente cliente) {
        return mm.map(cliente, ClienteVo.class);
    }

    public Cliente toEntity(ClienteVo vo) {
        return mm.map(vo, Cliente.class);
    }

    public List<ClienteVo> toListClienteVo(List<Cliente> clientes) {
        return clientes.stream().map(this::toVO).collect(Collectors.toList());
    }

    public List<Cliente> toListCliente(List<ClienteVo> vos) {
        return vos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    // Ativo
    // --------------------------------------------------
    public AtivoVo toVO(Ativo ativo) {
        return mm.map(ativo, AtivoVo.class);
    }

    public Ativo toEntity(AtivoVo vo) {
        return mm.map(vo, Ativo.class);
    }

    public List<AtivoVo> toListAtivoVo(List<Ativo> ativos) {
        return ativos.stream().map(this::toVO).collect(Collectors.toList());
    }

    public List<Ativo> toListAtivo(List<AtivoVo> vos) {
        return vos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    // Carteira
    // --------------------------------------------------
    public CarteiraVo toVO(Carteira carteira) {
        return mm.map(carteira, CarteiraVo.class);
    }

    public Carteira toEntity(CarteiraVo vo) {
        return mm.map(vo, Carteira.class);
    }

    public List<CarteiraVo> toListCarteiraVo(List<Carteira> carteiras) {
        return carteiras.stream().map(this::toVO).collect(Collectors.toList());
    }

    public List<Carteira> toListCarteira(List<CarteiraVo> vos) {
        return vos.stream().map(this::toEntity).collect(Collectors.toList());
    }
    
    // ItemCarteira
    // --------------------------------------------------
    public ItemCarteiraVo toVO(ItemCarteira item) {
        return mm.map(item, ItemCarteiraVo.class);
    }

    public ItemCarteira toEntity(ItemCarteiraVo vo) {
        return mm.map(vo, ItemCarteira.class);
    }

    public List<ItemCarteiraVo> toListItemCarteiraVO(List<ItemCarteira> itens) {
        return itens.stream().map(this::toVO).collect(Collectors.toList());
    }

    public List<ItemCarteira> toListItemCarteira(List<ItemCarteiraVo> vos) {
        return vos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}