package co.edu.uco.tiendaonline.service.domain.cliente.rules.support.nombre;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;

public class NombreCompletoClienteValidationRule implements ValidationRule<NombreCompletoClienteDomain> {

	private static final ValidationRule<NombreCompletoClienteDomain> instancia = new NombreCompletoClienteValidationRule();

	public static final void ejecutarValidacion(final NombreCompletoClienteDomain data) {
		instancia.validator(data);
	}

	@Override
	public final void validator(final NombreCompletoClienteDomain dato) {

		if (UtilObjeto.esNulo(dato)) {
			throw ServiceTiendaOnlineException.crear(
					"No es pisble llevar a cabo la operacion deseada con el Tipo de Identificacion, ya que no existen datos paa lleva a cabo la operacion deseada...");
		}
	}

}
