package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroCelularClienteEntity;

public class ClienteEntity {

	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroCelularClienteEntity numeroCelular;
	private Date fechaNacimineto;

	public ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteEntity nombreCompleto, final CorreoElectronicoClienteEntity correoElectronico,
			NumeroCelularClienteEntity numeroCelular, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroCelular(numeroCelular);
		setFechaNacimineto(fechaNacimiento);
	}

	public static final ClienteEntity crear(final UUID id, final TipoIdentificacionEntity tipoIdentificacion,
			final String identificacion, final NombreCompletoClienteEntity nombreCompleto,
			final CorreoElectronicoClienteEntity correoElectronico, final NumeroCelularClienteEntity numeroCelular,
			final Date fechaNacimiento) {
		return new ClienteEntity(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico,
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

	public final NumeroCelularClienteEntity getNumeroCelular() {
		return numeroCelular;
	}

	private final void setNumeroCelular(NumeroCelularClienteEntity numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public final CorreoElectronicoClienteEntity getCorreoElectronico() {
		return correoElectronico;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	private final void setIdentificacion(final String indetificacion) {
		this.identificacion = indetificacion;
	}

	private final void setCorreoElectronico(CorreoElectronicoClienteEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}

	private final void setNombreCompleto(NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public final UUID getId() {
		return id;
	}

	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}

}
