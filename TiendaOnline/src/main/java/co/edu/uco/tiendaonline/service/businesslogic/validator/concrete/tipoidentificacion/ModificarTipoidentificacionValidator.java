package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public final class ModificarTipoidentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new ModificarTipoidentificacionValidator();
	private ModificarTipoidentificacionValidator() {
		
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.execute(dato);
	}
	
	@Override
	public void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());
		
	}
	
	public final void executes(final TipoIdentificacionDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilObjeto.esNulo(data.getId())) {
				IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
			}
		
		
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());
		}
	}

}
