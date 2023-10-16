package co.edu.uco.tiendaonline.crosscutting.util;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;



public class UtilUUID {

	public static final String UUID_POR_DEFECTO_COMO_TEXTO = "0000000-0000-0000-0000-00000000";
	public static final UUID UUID_POR_DEFECTO = UUID.fromString(UUID_POR_DEFECTO_COMO_TEXTO);

	private UtilUUID() {
		super();
	}

	public static final UUID obtenerUUIDDefecto(final UUID value) {
		return UtilObjeto.obtenerValorDefecto(value, UUID_POR_DEFECTO);
	}

	public static final UUID getNewUUID() {
		UUID uuid;

		do {
			uuid = UUID.randomUUID();

		} while (isDefualtUUID(uuid));
		return UUID.randomUUID();

	}

	public static final String obtenerUUIDComoTexto(final UUID valor) {
		return obtenerUUIDDefecto(valor).toString();
	}

	

	public static final boolean isDefualtUUID(final UUID value) {
		return UUID_POR_DEFECTO.equals(value);
	}

	public static UUID obtenerUUIDDeTexto(final String valor) {
		try {
			return UUID.fromString(UtilTexto.obtenerValorDefecto(valor, UUID_POR_DEFECTO_COMO_TEXTO));
		} catch (final IllegalCallerException exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"No ha sido posible crear el UUID, porfavor revisar de nuevo en la cracion de UUID");

		} catch (final Exception exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Ha ocurrido un error inesperado en la creacion de UUID porfavor revisar que todo este correcto. En caso de que no sea asi contactar al programador");
		}

	}
}
