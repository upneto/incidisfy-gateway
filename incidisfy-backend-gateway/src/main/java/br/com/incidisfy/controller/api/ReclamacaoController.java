package br.com.incidisfy.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@ApiOperation(value = "Pesquisa todas as reclamações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de Veiculos"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ReclamacaoPayload>> findAll() throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@ApiOperation(value = "Pesquisa reclamação por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna Veiculo"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(value = "/{id}", produces="application/json", consumes="application/json")
	public ResponseEntity<ReclamacaoPayload> findBy(@PathVariable long codigo) throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findBy(codigo), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@ApiOperation(value = "Insere reclamação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alterou Veiculo com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> insert(@RequestBody ReclamacaoPayload reclamacao) throws WebServiceException, BusinessException {
		this.service.insert(reclamacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@ApiOperation(value = "Altera reclamação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alterou Veiculo com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PutMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> update(@RequestBody ReclamacaoPayload reclamacao) throws WebServiceException, BusinessException {
		this.service.update(reclamacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
