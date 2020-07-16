package br.com.bxblue.fuzzytrader.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.type.AtivoType;
import br.com.bxblue.fuzzytrader.type.SimboloType;

@Service
public class AtivoServiceConsumer implements IAtivoServiceConsumer {

    private String URL_BASE = "http://api.marketstack.com/v1/eod/latest?";
    private String ACCESS_KEY = "6659e0ace417eb07bc0d21a3cc3d97f0";
    private String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";

    @Override
    public List<AtivoVo> obterDadosMaisRecentesAtivos() {

        List<AtivoVo> retorno = new ArrayList<>();

        String simbolos = String.format(
            "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
            SimboloType.AMAZONCOM_INC.getName(),
            SimboloType.APPLE_INC.getName(),
            SimboloType.FACEBOOK_INC.getName(),
            SimboloType.JOHNSON_JOHNSON.getName(),
            SimboloType.MASTERCARD_INC.getName(),
            SimboloType.MICROSOFT_CORP.getName(),
            SimboloType.NETFLIX_INC.getName(),
            SimboloType.NIKE_INC.getName(),
            SimboloType.THEWALTDISNEY_COMPANY.getName(),
            SimboloType.VISA_INV.getName());
        String parametros = "access_key=".concat(ACCESS_KEY).concat("&symbols=").concat(simbolos);
        String url = URL_BASE.concat(parametros);
        System.out.println(url);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET,entity,JsonNode.class);
        JsonNode results = response.getBody().get("data");
        AtivoVo vo;
        for (int i = 0; i < results.size(); i++) {
            String valor = results.get(i).get("close").asText();
            String simbolo = results.get(i).get("symbol").asText();
            BigDecimal bd = new BigDecimal(valor);
            vo = new AtivoVo(SimboloType.obterPorSimbolo(simbolo).toString(), simbolo, bd, AtivoType.ACAO);
            retorno.add(vo);
        }

        return retorno;
    }

}