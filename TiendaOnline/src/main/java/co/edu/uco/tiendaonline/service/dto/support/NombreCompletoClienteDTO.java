package co.edu.uco.tiendaonline.service.dto.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class NombreCompletoClienteDTO {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	

	private NombreCompletoClienteDTO(final String primerNombre,final String segundoNombre,final String primerApellido,
			final String segundoApellido) {
	setPrimerNombre(primerNombre);
	setSegundoNombre(segundoNombre);
	setPrimerApellido(primerApellido);
	setSegundoApellido(segundoApellido);
	}
	
	public NombreCompletoClienteDTO() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}

	public static final NombreCompletoClienteDTO crear(final String primerNombre,final String segundoNombre,final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoClienteDTO(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}

	public static final NombreCompletoClienteDTO crear() {
		return new NombreCompletoClienteDTO();
	}
	public final String getPrimerNombre() {
		return primerNombre;
	}

	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}




}