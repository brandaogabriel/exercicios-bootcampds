package com.gabrielexercicios.cp1.dtos;

public class ClientInsertDTO extends ClientDTO {
	private static final long serialVersionUID = 1L;

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
