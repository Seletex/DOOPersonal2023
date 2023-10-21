package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;


import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public class CodigoTipoIdentificacionValidationRule implements ValidationRule<String> {

	private static final ValidationRule<String> instancia = new CodigoTipoIdentificacionValidationRule();
	public static final void ejecutarValidacion(final String dato) {
		instancia.validator(dato);
	}
	
	@Override
	public final void validator(final String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);

	}

	private final void validarLongitud(final String dato) {
		if(UtilTexto.longitudMaximaValida(dato, 50)) {
			throw ServiceTiendaOnlineException.crear("La longitud del código del tipo de identificación no es valida. La longitud maxima son 50 caracteres");
		}
	}

	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			throw ServiceTiendaOnlineException.crear("El código del tipo de identificación es un dato obligatorio...");
			
		}
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			throw ServiceTiendaOnlineException.crear("El código del tipo de identificación solo puede contener letras...");
			
		}
	}

}
