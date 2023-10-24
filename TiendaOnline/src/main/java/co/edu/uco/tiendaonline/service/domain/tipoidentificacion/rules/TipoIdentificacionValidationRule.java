package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class TipoIdentificacionValidationRule implements ValidationRule<TipoIdentificacionDomain> {

	private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();

	public static final void ejecutarValidacion(final TipoIdentificacionDomain data) {
		instancia.validator(data);
	}

	@Override
	public final void validator(final TipoIdentificacionDomain dato) {

		if (UtilObjeto.esNulo(dato)) {
			throw ServiceTiendaOnlineException.crear(
					"No es pisble llevar a cabo la operacion deseada con el Tipo de Identificacion, ya que no existen datos paa lleva a cabo la operacion deseada...");
		}
	}

}