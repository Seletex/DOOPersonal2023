package co.edu.uco.tiendaonline.crosscutting.exception;

import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;


public class TiendaOnlineException extends RuntimeException {

	private static final long serialVersionUID = -551425372694998396L;

	private LugarException lugar;
	private Throwable exceptionRaiz;
	private String mensageUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;

	protected TiendaOnlineException(final LugarException lugar, final Throwable exceptionRaiz,
			final String mensageUsuario, final String mensajeTecnico) {
		setLugar(lugar);
		setExceptionRaiz(exceptionRaiz);
		setMensageUsuario(mensageUsuario);
		setMensajeTecnico(mensajeTecnico);

	}

	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}

	private final void setExceptionRaiz(final Throwable exceptionRaiz) {
		setTieneExcepcionRaiz(!UtilObjeto.esNulo(exceptionRaiz));
		this.exceptionRaiz =  UtilObjeto.obtenerValorDefecto(exceptionRaiz,new Exception());
	}

	private final void setMensageUsuario(final String mensageUsuario) {
		this.mensageUsuario = UtilTexto.aplicarTrim(mensageUsuario);
	}

	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	public final LugarException getLugar() {
		return lugar;
	}

	public final Throwable getExceptionRaiz() {
		return exceptionRaiz;
	}

	public final String getMensageUsuario() {
		return mensageUsuario;
	}

	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}

	private final void setTieneExcepcionRaiz(final boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz = tieneExcepcionRaiz;
	}
	
	

}
