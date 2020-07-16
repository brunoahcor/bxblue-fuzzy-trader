package br.com.bxblue.fuzzytrader.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;

@SpringBootTest
public class AtivoServiceTests {

    @Autowired
    private IAtivoService service;

    @Test
    public void listarTodosAtivos_sucesso() {
        List<AtivoVo> lista = service.listarTodosAtivos();
        lista.forEach(System.out::println);
        assertTrue( Optional.ofNullable(lista).isPresent() );
        assertEquals(10, lista.size());
    }

    @Test
    public void listarAtivosPorValor_100_sucesso() {
        List<AtivoVo> lista = service.listarAtivosPorValor(new BigDecimal("100"));
        lista.forEach(System.out::println);
        assertTrue( Optional.ofNullable(lista).isPresent() );
        assertEquals(1, lista.size());
    }

}