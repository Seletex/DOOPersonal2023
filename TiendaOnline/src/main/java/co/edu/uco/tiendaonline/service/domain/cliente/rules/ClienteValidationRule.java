package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;

public class ClienteValidationRule implements ValidationRule<ClienteDomain> {

	private static final ValidationRule<ClienteDomain> instancia = new ClienteValidationRule();

	public static final void ejecutarValidacion(final ClienteDomain data) {
		instancia.validator(data);
	}

	@Override
	public final void validator(final ClienteDomain dato) {

		if (UtilObjeto.esNulo(dato)) {
			throw ServiceTiendaOnlineException.crear(
					"No es pisble llevar a cabo la operacion deseada con el Tipo de Identificacion, ya que no existen datos paa lleva a cabo la operacion deseada...");
		}
	}

}