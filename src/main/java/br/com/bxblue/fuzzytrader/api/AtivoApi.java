package br.com.bxblue.fuzzytrader.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bxblue.fuzzytrader.model.vo.AtivoVo;
import br.com.bxblue.fuzzytrader.service.IAtivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "API desenvolvida para efetuar as operações dos ativos")
@RestController
@RequestMapping("/api/ativos")
public class AtivoApi {

    @Autowired
    private IAtivoService service;

    @ApiOperation(value = "Retorna uma lista com todos os ativos cadastrados no banco de dados.", response = ResponseEntity.class)	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso!"),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @GetMapping
    public List<AtivoVo> listar() {
        return service.listar();
    }

    @ApiOperation(value = "Retorna uma lista com todos os ativos.", response = ResponseEntity.class)	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso!"),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @RequestMapping(value = "/obterAtivosAPI", 
                    method = RequestMethod.GET, 
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AtivoVo> obterAtivosAPI() {
        return service.listarTodosAtivos();
    }

    @ApiOperation(value = "Retorna uma lista de ativos com base no valor informado.", response = ResponseEntity.class)	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso!"),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @RequestMapping(value = "/{valor}/obterAtivosAPIPorValor", 
                    method = RequestMethod.GET, 
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AtivoVo> obterAtivosAPIPorValor(@PathVariable("valor") BigDecimal valor) {
        return service.listarAtivosPorValor(valor);
    }
    
}