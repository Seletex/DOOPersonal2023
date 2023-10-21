package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain>{

	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain>
	instancia = new TipoIdentificacionDTOMapper();

	private TipoIdentificacionDTOMapper() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public final TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(),
				dto.isEstado());
	}

	@Override
	public final TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return TipoIdentificacionDTO.crear(domain.getId(), domain.getCodigo(), domain.getNombre(),
				domain.isEstado());
	}
	
	public static final TipoIdentificacionDomain converToDomain(final TipoIdentificacionDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoIdentificacionDTO converToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}

}
