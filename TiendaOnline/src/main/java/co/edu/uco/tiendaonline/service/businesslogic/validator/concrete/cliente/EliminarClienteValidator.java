package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;


import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdClienteValidationRule;


public class EliminarClienteValidator implements Validator<ClienteDomain> {

	private static final Validator<ClienteDomain> instancia = new EliminarClienteValidator();

	private EliminarClienteValidator() {

	}

	public static final void ejecutarValidacion(final ClienteDomain dato) {
		instancia.execute(dato);
	}

	@Override
	public void execute(final ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		IdClienteValidationRule.ejecutarValidacion(data.getId());

	}

	
}
