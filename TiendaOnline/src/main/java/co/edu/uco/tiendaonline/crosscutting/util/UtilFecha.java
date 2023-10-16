package co.edu.uco.tiendaonline.crosscutting.util;

import java.util.Date;

public final class UtilFecha {

	public static final String FECHA_POR_DEFECTO_TEXTO = "2023-01-01";
	protected static final Date FECHA_POR_DEFECTO_DATE = new Date(01 / 01 / 2500);

	private UtilFecha() {
		super();
	}

	public static final Date obtenerValorDefecto(final Date valor, final Date valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final Date obtenerValorDefecto(final Date valor) {
		return obtenerValorDefecto(valor, FECHA_POR_DEFECTO_DATE);
	}
	
	public static final String obtenerValorDefectoTexto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}

	public static final String obtenerValorDefectoTexto(final String valor) {
		return obtenerValorDefectoTexto(valor, FECHA_POR_DEFECTO_TEXTO);
	}

	public static final boolean estaNulo(final Date valor) {
		return UtilObjeto.esNulo(valor);
	}
	
	
}
