package br.com.incidisfy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.incidisfy.controller.payload.produto.ProdutoPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;

@Service
public class ProdutoService extends AbstractService {
	
	@Autowired
	public ProdutoService(RestTemplateBuilder builder) {
	    super(builder);
	}
	
	/**
	 * Variavel injetada pelo contexto Spring
	 * 		'env' = variavel injetada da runtime jvm
	 * 		'.url.backend.ordem_servico' = arquivo application.properties  
	 */
	@Value("${${env}.url.backend.produto}")
	private String url = null;
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<ProdutoPayload> findAll() throws WebServiceException, BusinessException {
		return super.doGetList(url, ProdutoPayload.class);
	}
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public ProdutoPayload findBy(Long id) throws WebServiceException, BusinessException {
		return super.doGet(url + id, ProdutoPayload.class);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void insert(ProdutoPayload obj) throws WebServiceException, BusinessException {
		super.doPost(url, obj);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void update(ProdutoPayload obj) throws WebServiceException, BusinessException {
		super.doPut(url, obj);
	}
	
	/**
	 * 
	 * @param id
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void delete(Long codigo) throws WebServiceException, BusinessException {
		super.doDelete(url + codigo);
	}
}
