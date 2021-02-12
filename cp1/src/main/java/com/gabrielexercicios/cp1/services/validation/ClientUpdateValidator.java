package com.gabrielexercicios.cp1.services.validation;

import com.gabrielexercicios.cp1.dtos.ClientUpdateDTO;
import com.gabrielexercicios.cp1.entities.Client;
import com.gabrielexercicios.cp1.repositories.ClientRepository;
import com.gabrielexercicios.cp1.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdateValid, ClientUpdateDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void initialize(ClientUpdateValid constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClientUpdateDTO value, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long clientId = Long.parseLong(uriVars.get("id"));

		Client client = clientRepository.findByCpf(value.getCpf());
		List<FieldMessage> errors = new ArrayList<>();

		if(client == null || !client.getId().equals(clientId))
			errors.add(new FieldMessage("cpf", "CPF não pode ser alterado"));

		for(FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return errors.isEmpty();
	}
}
