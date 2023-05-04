package br.com.incidisfy.controller.payload.produto;

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
public class ProdutoPayload {

	private Long codigo;
	private String descricao;	
	private String marca;	
	private String modelo;
}
