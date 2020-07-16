package br.com.bxblue.fuzzytrader.model.vo;

import java.math.BigDecimal;

import br.com.bxblue.fuzzytrader.type.AtivoType;
import io.swagger.annotations.ApiModelProperty;
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
public class AtivoVo {

    @ApiModelProperty(hidden = true)
    private Long id;
    private String nome;
    private String simbolo;
    private BigDecimal valor;
    private AtivoType tipo;

    public AtivoVo(String nome, String simbolo, BigDecimal valor, AtivoType tipo) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.valor = valor;
        this.tipo = tipo;
    }

}