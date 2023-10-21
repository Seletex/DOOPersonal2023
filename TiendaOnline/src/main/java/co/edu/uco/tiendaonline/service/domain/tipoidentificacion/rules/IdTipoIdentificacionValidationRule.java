package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;


import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public class IdTipoIdentificacionValidationRule implements ValidationRule<UUID> {

	private static final ValidationRule<UUID> instancia = new IdTipoIdentificacionValidationRule();
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validator(dato);
	}
	
	
	@Override
	public final void validator(final UUID dato) {
		
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
		validarFormato(dato);
		validarLongitud(dato);
	}

	private final void validarLongitud(final UUID dato) {
		if(UtilTexto.longitudValida(UtilUUID.obtenerUUIDComoTexto(dato),36,36)) {
			throw ServiceTiendaOnlineException.crear("La longitud del nombre del tipo de identificación no es valida. La longitud maxima son 50 caracteres");
		}
	}

	private final void validarObligatoriedad(final UUID dato) {
		if(UtilTexto.estaVacio(UtilUUID.obtenerUUIDComoTexto(dato))) {
			throw ServiceTiendaOnlineException.crear("El nombre del tipo de identificación es un dato obligatorio...");
			
		}
	}

	private final void validarFormato(final UUID dato) {
		if(!UtilTexto.contieneSoloLetrasCompletas(UtilUUID.obtenerUUIDComoTexto(dato))) {
			throw ServiceTiendaOnlineException.crear("El nombre del tipo de identificación solo puede contener letras...");
			
		}
	}
	private final void validarIdPorDefecto(final UUID dato) {
		if(UtilUUID.esUUIDPorDefecto(dato)) {
			throw ServiceTiendaOnlineException.crear("El id del tipo de identificacion no puede ser igual al por defecto");
		}
	}

}
