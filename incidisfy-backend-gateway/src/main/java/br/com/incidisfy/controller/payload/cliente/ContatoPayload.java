package br.com.incidisfy.controller.payload.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the dt_contatos database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoPayload {

	private Long codigo;	
	private String descricao;
	private int tipoContato;
	private Long cliente;

}