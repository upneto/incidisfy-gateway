package br.com.incidisfy.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.incidisfy.controller.payload.login.LoginRequest;
import br.com.incidisfy.controller.payload.login.LoginResponse;
import br.com.incidisfy.controller.payload.login.TokenRequest;
import br.com.incidisfy.resources.exception.AutenticatorException;
import br.com.incidisfy.resources.utils.JwtUtils;

/**
 * Servico de manipulação dos dados do usuário 
 * @author Ulisses Neto
 */
@Service
public class LoginService extends AbstractService {

	@Autowired
	public LoginService(RestTemplateBuilder builder) {
		super(builder);
	}
	
	/**
	 * O micro servico de autenticacao está fora do escopo do projeto.
	 * Por esse motivo a validação será estática atraves da lista abaixo.
	 */
	private static final List<LoginRequest> _USUARIOS = Arrays.asList(
			LoginRequest.builder().usuario("fiap").senha("fiap2023").build(),
			LoginRequest.builder().usuario("admin").senha("fiap2023").build()
			);
	
	/**
	 * Efetiva a autenticação do usuário
	 * @param request
	 * @return
	 * @throws AutenticatorException 
	 */
	public LoginResponse doLogin(LoginRequest request) throws AutenticatorException {
		if(request.getUsuario() == null
				|| request.getSenha() == null
				|| request.getUsuario().isBlank()
				|| request.getSenha().isBlank()) {	
			throw new AutenticatorException("Usuário e(ou) Senha inválidos!");
		}
		else if (!_USUARIOS.contains(request)) {			
			throw new AutenticatorException("Usuário e(ou) Senha inválidos!");
		}
		return LoginResponse.builder()
				.usuario(request.getUsuario())
				.nome("USUÁRIO TESTE FIAP 2023")
				.token(JwtUtils.getInstance().getToken(request.getUsuario())) 
				.build();
	}

	/**
	 * Verifica se token está ativo
	 * @param request
	 * @throws AutenticatorException 
	 */
	public void doVerify(TokenRequest request) throws AutenticatorException {
		JwtUtils.getInstance().validateToken(request.getToken());		
	}

	
}
