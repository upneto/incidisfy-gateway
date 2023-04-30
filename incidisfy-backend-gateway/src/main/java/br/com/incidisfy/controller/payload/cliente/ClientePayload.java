package br.com.incidisfy.controller.payload.cliente;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataCriacao;
	private String informacao;
	private String nome;
	private String nomeRazaoSocial;
	private int tipoPessoa;
	private List<ContatoPayload> contatos;
	private List<EnderecoPayload> enderecos;

}
