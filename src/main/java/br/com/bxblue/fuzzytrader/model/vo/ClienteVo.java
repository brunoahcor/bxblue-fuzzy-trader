package br.com.bxblue.fuzzytrader.model.vo;

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
public class ClienteVo {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    
}