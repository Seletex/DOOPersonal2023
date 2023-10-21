package co.edu.uco.tiendaonline.crosscutting.util;

public final class UtilTexto {

	public static final String VACIO = "";
	public static final String PATTERN_SOLO_LETRAS="[A-Za-záéíóúÁÉÍÓÚ]+$";
	public static final String PATTERN_SOLO_LETRAS_ESPECIALES="^[0-9A-Za-záéíóúÁÉÍÓÚ ]+$";
	public static final String PATTERN_SOLO_LETRAS_ESPACIOS="[A-Za-záéíóúÁÉÍÓÚ1-100]+$";
	private UtilTexto() {

	}

	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}

	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}

	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}

	public static final boolean igualSinTrim(final String valorUno, final String valorDos) {
		return valorUno.equals(valorDos);
	}

	public static final boolean igualConTrim(final String valorUno, final String valorDos) {
		return aplicarTrim(valorUno).equals(aplicarTrim(valorDos));
	}

	public static final boolean igualSinTrimIgnoreCase(final String valorUno, final String valorDos) {
		return valorUno.equalsIgnoreCase(valorDos);
	}

	public static final boolean igualConTrimIgnoreCase(final String valorUno, final String valorDos) {
		return aplicarTrim(valorUno).equalsIgnoreCase(aplicarTrim(valorDos));
	}

	public static final boolean estaNulo(final String valor) {
		return UtilObjeto.esNulo(valor);
	}

	public static final boolean estaVacio(final String valor) {
		return !estaNulo(valor) && igualConTrim(valor, VACIO);
	}

	public static final boolean longitudMinimaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() >= longitud;
	}

	public static final boolean longitudMaximaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() <= longitud;
	}

	public static final boolean longitudValida(final String valor, final int longitudMinima, final int longiudMaxima) {
		return longitudMinimaValida(valor, longitudMinima) && longitudMaximaValida(valor, longiudMaxima);
	}

	public static final boolean contieneSoloLetras(final String valor) {
		return aplicarTrim(valor).matches(PATTERN_SOLO_LETRAS);
	}
	public static final boolean contieneSoloLetrasCompletas(final String valor) {
		return aplicarTrim(valor).matches(PATTERN_SOLO_LETRAS_ESPECIALES);
	}
}
