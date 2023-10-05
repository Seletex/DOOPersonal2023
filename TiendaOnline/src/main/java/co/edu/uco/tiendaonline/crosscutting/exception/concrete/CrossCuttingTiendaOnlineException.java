package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class CrossCuttingTiendaOnlineException extends TiendaOnlineException {

	private static final long serialVersionUID = -9177484194126685659L;
	
	protected CrossCuttingTiendaOnlineException(final Throwable exceptionRaiz, final String mensageUsuario,
			final String mensajeTecnico) {
		super(LugarException.CROSSCUTTING, exceptionRaiz, mensageUsuario, mensajeTecnico);
		
	}

	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new CrossCuttingTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}


}
