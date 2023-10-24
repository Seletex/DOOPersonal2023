package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;


import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;

import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public class EliminarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain> {

	private static final Validator<TipoIdentificacionDomain> instancia = new EliminarTipoIdentificacionValidator();

	private EliminarTipoIdentificacionValidator() {

	}

	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.execute(dato);
	}

	@Override
	public void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());

	}

	
}
