package br.com.incidisfy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.incidisfy.controller.payload.categoria.CategoriaPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;

@Service
public class CategoriaService extends AbstractService {
	
	@Autowired
	public CategoriaService(RestTemplateBuilder builder) {
	    super(builder);
	}
	
	/**
	 * Variavel injetada pelo contexto Spring
	 * 		'env' = variavel injetada da runtime jvm
	 * 		'.url.backend.ordem_servico' = arquivo application.properties  
	 */
	@Value("${${env}.url.backend.categoria}")
	private String url = null;
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<CategoriaPayload> findAll() throws WebServiceException, BusinessException {
		return super.doGetList(url, CategoriaPayload.class);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void insert(CategoriaPayload obj) throws WebServiceException, BusinessException {
		super.doPost(url, obj);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void update(CategoriaPayload obj) throws WebServiceException, BusinessException {
		super.doPut(url, obj);
	}
	
	/**
	 * 
	 * @param id
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void delete(Integer codigo) throws WebServiceException, BusinessException {
		super.doDelete(url + codigo);
	}
}
