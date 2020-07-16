package br.com.bxblue.fuzzytrader.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bxblue.fuzzytrader.model.vo.ClienteVo;
import br.com.bxblue.fuzzytrader.service.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "API desenvolvida para efetuar as operações do cliente.")
@RestController
@RequestMapping("/api/clientes")
public class ClienteApi {

    @Autowired
    private IClienteService service;

    @ApiOperation(value = "Retorna uma lista com todos os clientes cadastrados no banco de dados.", response = ResponseEntity.class)	
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso!"),
            @ApiResponse(code = 401, message = "Usuário não autenticado."),
            @ApiResponse(code = 403, message = "Usuário não possui autorização para acessar o recurso."),
	        @ApiResponse(code = 404, message = "O recurso nao foi encontrado."),
	        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado, contate o administrador.")
	})
    @GetMapping
    public List<ClienteVo> listarTodosClientes() {
        return service.listar();
    }
    
}