package br.com.incidisfy.controller.payload.reclamacao;

import java.util.Date;

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
public class ReclamacaoPayload {

	private String codigo;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataCriacao;
	private long codigoCliente;
	private int codigoCategoria;
	private long codigoProduto;
	private String descricao;
	
}
