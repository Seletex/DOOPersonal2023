package co.edu.uco.tiendaonline.service.domain.cliente.rules.support.numerocelular;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.service.domain.ValidationRule;


import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroCelularClienteDomain;

public class NumeroCelularClienteValidationRule implements ValidationRule<NumeroCelularClienteDomain> {

	private static final ValidationRule<NumeroCelularClienteDomain> instancia = new NumeroCelularClienteValidationRule();

	public static final void ejecutarValidacion(final NumeroCelularClienteDomain data) {
		instancia.validator(data);
	}

	@Override
	public final void validator(final NumeroCelularClienteDomain dato) {

		if (UtilObjeto.esNulo(dato)) {
			throw ServiceTiendaOnlineException.crear(
					"No es pisble llevar a cabo la operacion deseada con el Tipo de Identificacion, ya que no existen datos paa lleva a cabo la operacion deseada...");
		}
	}
}
