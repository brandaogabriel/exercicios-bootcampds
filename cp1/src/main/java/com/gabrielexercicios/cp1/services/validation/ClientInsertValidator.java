package com.gabrielexercicios.cp1.services.validation;

import com.gabrielexercicios.cp1.dtos.ClientInsertDTO;
import com.gabrielexercicios.cp1.entities.Client;
import com.gabrielexercicios.cp1.repositories.ClientRepository;
import com.gabrielexercicios.cp1.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsertValid, ClientInsertDTO> {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void initialize(ClientInsertValid constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClientInsertDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> errors = new ArrayList<>();

		Client client = clientRepository.findByCpf(value.getCpf());
		if(client != null)
			errors.add(new FieldMessage("cpf", "Cpf já cadastrado"));

		for(FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return errors.isEmpty();
	}
}
