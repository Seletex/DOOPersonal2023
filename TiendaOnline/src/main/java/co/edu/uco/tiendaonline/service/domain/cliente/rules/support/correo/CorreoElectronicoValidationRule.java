package co.edu.uco.tiendaonline.service.domain.cliente.rules.support.correo;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;




public class CorreoElectronicoValidationRule  implements ValidationRule<CorreoElectronicoClienteDomain> {

	private static final ValidationRule<CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoValidationRule();


	public static final void ejecutarValidacion(final CorreoElectronicoClienteDomain data) {
		instancia.validator(data);
	}

	@Override
	public final void validator(final CorreoElectronicoClienteDomain dato) {

		if (UtilObjeto.esNulo(dato)) {
			throw ServiceTiendaOnlineException.crear(
					"No es pisble llevar a cabo la operacion deseada con el Tipo de Identificacion, ya que no existen datos paa lleva a cabo la operacion deseada...");
		}
	}
}
