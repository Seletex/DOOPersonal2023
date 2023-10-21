package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public final class RegistrarTipoidentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new RegistrarTipoidentificacionValidator();
	private RegistrarTipoidentificacionValidator() {
		
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.execute(dato);
	}
	
	@Override
	public void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());
		
	}

}
