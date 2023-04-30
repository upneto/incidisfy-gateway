package br.com.incidisfy.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.incidisfy.controller.payload.produto.ProdutoPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;
import br.com.incidisfy.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@ApiOperation(value = "Pesquisa todos os Produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de Produtos"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ProdutoPayload>> findAll() throws WebServiceException, BusinessException  {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Pesquisa Produto por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna Produto"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(value = "/{codigo}", produces="application/json", consumes="application/json")
	public ResponseEntity<ProdutoPayload> findBy(@PathVariable long codigo) throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findBy(codigo), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Grava novo Produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Gravou Produto com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> insert(@RequestBody ProdutoPayload pessoa) throws WebServiceException, BusinessException {
		this.service.insert(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Altera Produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alterou Produto com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PutMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> update(@RequestBody ProdutoPayload pessoa) throws WebServiceException, BusinessException {
		this.service.update(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Remove Produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removeu Produto com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@DeleteMapping(value = "/{codigo}", produces="application/json", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable long codigo) throws WebServiceException, BusinessException {
		this.service.delete(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
