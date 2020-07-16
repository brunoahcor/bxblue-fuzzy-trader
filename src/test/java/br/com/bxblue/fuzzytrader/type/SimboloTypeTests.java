package br.com.bxblue.fuzzytrader.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimboloTypeTests {

    @Test
    public void obterPorSimbolo_encontrado() {
        assertEquals(SimboloType.FACEBOOK_INC, SimboloType.obterPorSimbolo("FB"));
    }

    @Test
    public void obterPorSimbolo_null() {
        assertEquals(null, SimboloType.obterPorSimbolo("NAO_EXISTE"));
    }
    
}