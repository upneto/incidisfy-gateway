package br.com.incidisfy.controller.payload.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the dt_enderecos database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoPayload {

	private Long codigo;
	private String bairro;
	private String cep;
	private String cidade;
	private String complemento;	
	private String estado;
	private String numero;
	private String pais;
	private String rua;
	private Long cliente;

}