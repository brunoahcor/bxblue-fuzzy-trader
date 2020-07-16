package br.com.bxblue.fuzzytrader.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bxblue.fuzzytrader.model.vo.CarteiraVo;
import br.com.bxblue.fuzzytrader.model.vo.NovaCarteiraVo;
import br.com.bxblue.fuzzytrader.service.ICarteiraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "API desenvolvida para efetuar as operações da carteira do cliente")
@RestController
@RequestMapping("/api/carteiras")
public class CarteiraApi {

    @Autowired
    private ICarteiraService service;

    @ApiOperation(value = "Retorna uma lista com todos os clientes cadastrados no banco de dados.", response = ResponseEntity.class)	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso!"),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @RequestMapping(value = "/{id}/obterCarteiraPorCliente", 
                    method = RequestMethod.GET, 
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public CarteiraVo obterCarteiraPorCliente(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @ApiOperation(value = "Salva o carteira no banco de dados.", response = ResponseEntity.class)	
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Carteira inserida com sucesso!"),
            @ApiResponse(code = 400, message = "Requisicao invalida."),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @RequestMapping(value = "/salvar", 
                    method = RequestMethod.PUT, 
                    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<?> salvar(@Valid @RequestBody NovaCarteiraVo vo) {

        try {
            CarteiraVo retorno = service.salvar(vo);
            return new ResponseEntity<CarteiraVo>(retorno, HttpStatus.CREATED);
        } catch (final Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}