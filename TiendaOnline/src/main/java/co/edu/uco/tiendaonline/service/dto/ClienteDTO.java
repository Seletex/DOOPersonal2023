package co.edu.uco.tiendaonline.service.dto;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NumeroCelularClienteDTO;



public class ClienteDTO {
	
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private NumeroCelularClienteDTO numeroCelular;
	private Date fechaNacimineto;
	
	public ClienteDTO() {
		setId(id);
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setIdentificacion(identificacion);
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectronico(new CorreoElectronicoClienteDTO());
		setNumeroCelular(numeroCelular);
		setFechaNacimineto(fechaNacimineto);// Lograr que por defecto se asigne  una fecha que no sea valida
	}
	
	public ClienteDTO(final UUID id,final  TipoIdentificacionDTO tipoIdentificacion,final  String identificacion,
			final 	NombreCompletoClienteDTO nombreCompleto,final  CorreoElectronicoClienteDTO correoElectronico,
			final NumeroCelularClienteDTO numeroCelular,final  Date fechaNacimineto) {
		
	setId(id);
	setTipoIdentificacion(tipoIdentificacion);
	setIdentificacion(identificacion);
	setNombreCompleto(nombreCompleto);
	setCorreoElectronico(correoElectronico);
	setNumeroCelular(numeroCelular);
	setFechaNacimineto(fechaNacimineto);// Lograr que por defecto se asigne  una fecha que no sea valida
		
	}
	
	public static final ClienteDTO crear() {
		return new ClienteDTO();
	}
	public final UUID getId() {
		return id;
	}
	public final ClienteDTO setId(UUID id) {
		this.id = id;return this;
	}
	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final ClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;return this;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;return this;
	}
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;return this;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}
	public final ClienteDTO setCorreoElectronico(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = correoElectronico;return this;
	}
	public final NumeroCelularClienteDTO getNumeroCelular() {
		return numeroCelular;
	}
	public final ClienteDTO setNumeroCelular(final NumeroCelularClienteDTO numeroCelular) {
		this.numeroCelular = numeroCelular;return this;
	}
	public final Date getFechaNacimineto() {
		return fechaNacimineto;
	}
	public final ClienteDTO setFechaNacimineto(final Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;return this;
	}
	
	

}
