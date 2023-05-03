package br.com.incidisfy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.incidisfy.controller.payload.reclamacao.ReclamacaoPayload;
import br.com.incidisfy.resources.exception.BusinessException;
import br.com.incidisfy.resources.exception.WebServiceException;

@Service
public class ReclamacaoService extends AbstractService {
	
	@Autowired
	public ReclamacaoService(RestTemplateBuilder builder) {
	    super(builder);
	}
	
	/**
	 * Variavel injetada pelo contexto Spring
	 * 		'env' = variavel injetada da runtime jvm
	 * 		'.url.backend.ordem_servico' = arquivo application.properties  
	 */
	@Value("${${spring.profiles.active}.url.backend.reclamacao}")
	private String url = null;
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<ReclamacaoPayload> findAll() throws WebServiceException, BusinessException {
		return super.doGetList(url, ReclamacaoPayload.class);
	}
	
	/**
	 * 
	 * @return
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public ReclamacaoPayload findBy(Long id) throws WebServiceException, BusinessException {
		return super.doGet(url + id, ReclamacaoPayload.class);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void insert(ReclamacaoPayload obj) throws WebServiceException, BusinessException {
		super.doPost(url, obj);
	}
	
	/**
	 * 
	 * @param cliente
	 * @throws WebServiceException
	 * @throws BusinessException
	 */
	public void update(ReclamacaoPayload obj) throws WebServiceException, BusinessException {
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
