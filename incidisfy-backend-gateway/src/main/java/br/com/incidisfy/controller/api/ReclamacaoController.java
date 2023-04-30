package br.com.incidisfy.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.incidisfy.controller.payload.reclamacao.ReclamacaoPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;
import br.com.incidisfy.service.ReclamacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/reclamacao")
public class ReclamacaoController {

	@Autowired
	private ReclamacaoService service;
	
	@ApiOperation(value = "Pesquisa todos os Veiculos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de Veiculos"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ReclamacaoPayload>> findAll() throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Pesquisa Veiculo por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna Veiculo"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(value = "/{id}", produces="application/json", consumes="application/json")
	public ResponseEntity<ReclamacaoPayload> findBy(@PathVariable long id) throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findBy(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Altera Veiculo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alterou Veiculo com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PutMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> update(@RequestBody ReclamacaoPayload pessoa) throws WebServiceException, BusinessException {
		this.service.update(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
