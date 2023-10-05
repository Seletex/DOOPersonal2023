package co.edu.uco.tiendaonline.crosscutting.mensajes;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {

	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();

	static {
		cargarMensjaes();
	}

	private CatalogoMensajes() {

	}

	private static final void cargarMensjaes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No se recibio el coigo del mensaje que se queria crear, no es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No existe un mensaje con el codigo indica. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No es posible obtener un mensaje con un codigo vacio nulo. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL,
				"Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada. Porfavor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"));
		agregarMensaje(Mensaje.crear(
				CodigoMensaje.M00000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se presente una excepcion de tipo SQLException porfavor verifique la traza completa del error presentado para asi verificar con mayor certeza que paso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000006, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"Se presente una excepcion de tipo Exception porfavor verifique la traza completa del error presentado para asi verificar con mayor certeza que paso	"));	
	}

	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {
			
			throw CrossCuttingTiendaOnlineException.crear(obtenerContenidoMensaje(CodigoMensaje.M00000004),
					obtenerContenidoMensaje(CodigoMensaje.M00000003));
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			throw CrossCuttingTiendaOnlineException.crear(obtenerContenidoMensaje(CodigoMensaje.M00000004),
					obtenerContenidoMensaje(CodigoMensaje.M00000002));
		}
		return MENSAJES.get(codigo);
		
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}

	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
}
