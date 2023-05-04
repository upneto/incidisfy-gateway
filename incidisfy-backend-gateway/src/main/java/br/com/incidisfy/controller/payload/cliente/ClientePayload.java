package br.com.incidisfy.controller.payload.cliente;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientePayload {

	private Long documento;	
	private String informacao;
	private String nome;
	private String nomeRazaoSocial;	
	private List<ContatoPayload> contatos;
	private List<EnderecoPayload> enderecos;

}
