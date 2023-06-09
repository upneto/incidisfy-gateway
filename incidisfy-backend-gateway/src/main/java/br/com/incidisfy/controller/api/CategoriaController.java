package br.com.incidisfy.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.incidisfy.controller.payload.categoria.CategoriaPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;
import br.com.incidisfy.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException 
	 */
	@ApiOperation(value = "Pesquisa lista de Categorias")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na pesquisa por lista de categorias"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(produces="application/json")
	public ResponseEntity<List<CategoriaPayload>> findAll() throws WebServiceException, BusinessException {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
}
