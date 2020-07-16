package br.com.bxblue.fuzzytrader.model.vo;

import java.math.BigDecimal;
import java.util.List;

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
public class NovaCarteiraVo {

    private String clienteCpf;
    private BigDecimal valorInvestimento;
    private List<String> ativosSimbolo;
    
}