package co.edu.uco.tiendaonline.service.domain;

import java.sql.Date;
import java.util.UUID;


import co.edu.uco.tiendaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.support.NumeroCelularClienteDomain;

public class ClienteDomain {

	private UUID id;
	private TipoIdentificacionDomain tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private NumeroCelularClienteDomain numeroCelular;
	private Date fechaNacimineto;

	public ClienteDomain(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDomain nombreCompleto, final CorreoElectronicoClienteDomain correoElectronico,
			NumeroCelularClienteDomain numeroCelular, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroCelular(numeroCelular);
		setFechaNacimineto(fechaNacimiento);
	}

	public static final ClienteDomain crear(final UUID id, final TipoIdentificacionDomain tipoIdentificacion,
			final String identificacion, final NombreCompletoClienteDomain nombreCompleto,
			final CorreoElectronicoClienteDomain correoElectronico, final NumeroCelularClienteDomain numeroCelular,
			final Date fechaNacimiento) {
		return new ClienteDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico,
				numeroCelular, fechaNacimiento);
	}

	public final Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	private final void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final NumeroCelularClienteDomain getNumeroCelular() {
		return numeroCelular;
	}

	private final void setNumeroCelular(NumeroCelularClienteDomain numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public final CorreoElectronicoClienteDomain getCorreoElectronico() {
		return correoElectronico;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setIdentificacion(final String indetificacion) {
		this.identificacion = indetificacion;
	}

	private final void setCorreoElectronico(CorreoElectronicoClienteDomain correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}

	private final void setNombreCompleto(NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public final UUID getId() {
		return id;
	}

	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

}
