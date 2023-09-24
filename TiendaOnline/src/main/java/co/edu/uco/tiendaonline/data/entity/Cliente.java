package co.edu.uco.tiendaonline.data.entity;

import java.util.UUID;

public class Cliente {

	private UUID id;
	private TipoIdentificacion tipoIdentificacion;
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correoElectronico;
	private boolean confirmacionCorreoElectronico;
	private String numeroCelular;

	public Cliente(final UUID id, final TipoIdentificacion tipoIdentificacion, final String identificacion,
			final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido, final String correoElectronico, final boolean confirmacionCorreoElectronico,
			final String numeroCelular) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setCorreoElectronico(correoElectronico);
		setConfirmacionCorreoElectronico(confirmacionCorreoElectronico);
		setNumeroCelular(numeroCelular);
	}

	public static final Cliente crear(final UUID id, final TipoIdentificacion tipoIdentificacion,
			final String identificacion, final String primerNombre, final String segundoNombre,
			final String primerApellido, final String segundoApellido, final String correoElectronico,
			final boolean confirmacionCorreoElectronico, final String numeroCelular) {
		return new Cliente(id, tipoIdentificacion, identificacion, primerNombre, segundoNombre, primerApellido,
				segundoApellido, correoElectronico, confirmacionCorreoElectronico, numeroCelular);
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipoIdentificacion(final TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setIdentificacion(final String indetificacion) {
		this.identificacion = indetificacion;
	}

	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
	}

	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
	}

	private final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setConfirmacionCorreoElectronico(final boolean confirmacionCorreoElectronico) {
		this.confirmacionCorreoElectronico = confirmacionCorreoElectronico;
	}

	private final void setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public final UUID getId() {
		return id;
	}

	public final TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final String getIndentificacion() {
		return identificacion;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isConfirmacionCorreoElectronico() {
		return confirmacionCorreoElectronico;
	}

	public final String getNumeroCelular() {
		return numeroCelular;
	}

}
