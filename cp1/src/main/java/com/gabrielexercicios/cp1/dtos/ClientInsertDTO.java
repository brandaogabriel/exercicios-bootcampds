package com.gabrielexercicios.cp1.dtos;

import com.gabrielexercicios.cp1.services.validation.ClientInsertValid;

import javax.validation.constraints.NotBlank;

@ClientInsertValid
public class ClientInsertDTO extends ClientDTO {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Senha é obrigatório")
	private String password;

	public ClientInsertDTO() {
		super();
	}

	public ClientInsertDTO(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
