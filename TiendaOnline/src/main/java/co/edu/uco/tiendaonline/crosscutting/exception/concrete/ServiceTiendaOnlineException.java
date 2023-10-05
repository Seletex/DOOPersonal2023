package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class ServiceTiendaOnlineException extends TiendaOnlineException{


	private static final long serialVersionUID = -9177484194126685659L;
	
	protected ServiceTiendaOnlineException(final Throwable exceptionRaiz, final String mensageUsuario,
			final String mensajeTecnico) {
		super(LugarException.SERVICE, exceptionRaiz, mensageUsuario, mensajeTecnico);
		
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new ServiceTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}


}
