package com.gabrielexercicios.cp1.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1;

	private List<FieldMessage> erros = new ArrayList<>();

	public void addError(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
}
