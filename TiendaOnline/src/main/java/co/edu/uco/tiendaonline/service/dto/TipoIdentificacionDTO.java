package co.edu.uco.tiendaonline.service.dto;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;

public final class TipoIdentificacionDTO {

	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	public TipoIdentificacionDTO() {
		setId(UtilUUID.UUID_POR_DEFECTO); 
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
		setEstado(false);
	}
	
	public TipoIdentificacionDTO(final UUID id, final String codigo, final String nombre, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
		
		
	}
	
	public static final TipoIdentificacionDTO crear() {
		return new TipoIdentificacionDTO();
	}
	
	public static final TipoIdentificacionDTO crear(final UUID id, final String codigo, final String nombre, final boolean estado) {
		return new TipoIdentificacionDTO(id, codigo,nombre,estado);
	}
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO setId(final UUID id) {
		this.id = id;return this;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);return this;
	}
	public final boolean isEstado() {
		return estado;
	}
	public final TipoIdentificacionDTO setEstado(final boolean estado) {
		this.estado = estado;return this;
				
	}

	
	
	
}
