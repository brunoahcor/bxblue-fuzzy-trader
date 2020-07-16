package br.com.bxblue.fuzzytrader.model.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemCarteiraVo {

    private Long id;
    private BigDecimal valorCompra;
    private BigDecimal valorTotal;
    private Double cotas;
    private AtivoVo ativo;
    
}