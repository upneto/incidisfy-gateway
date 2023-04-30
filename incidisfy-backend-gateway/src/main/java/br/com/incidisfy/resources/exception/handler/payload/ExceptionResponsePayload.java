package br.com.incidisfy.resources.exception.handler.payload;

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
public class ExceptionResponsePayload {

	private int code;
	private String description;
	private Throwable exception;
}
