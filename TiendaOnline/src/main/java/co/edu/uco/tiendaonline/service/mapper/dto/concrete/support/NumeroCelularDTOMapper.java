package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;



import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroCelularClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NumeroCelularClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public class NumeroCelularDTOMapper implements DTOMapper<NumeroCelularClienteDTO, NumeroCelularClienteDomain> {

	private static final DTOMapper<NumeroCelularClienteDTO, NumeroCelularClienteDomain>
	instancia = new NumeroCelularDTOMapper();

	private NumeroCelularDTOMapper() {
		super();
	}

	@Override
	public NumeroCelularClienteDomain toDomain(NumeroCelularClienteDTO entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return NumeroCelularClienteDomain.crear(entity.getNumeroCelular(), entity.getNumeroCelularConfirmado());
	}

	@Override
	public NumeroCelularClienteDTO toDTO(NumeroCelularClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return NumeroCelularClienteDTO.crear(domain.getNumeroCelular(),domain.getNumeroCelularConfirmado());
	}
	
	public static final NumeroCelularClienteDomain converToDomain(final NumeroCelularClienteDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroCelularClienteDTO converToDTO(final NumeroCelularClienteDomain domain) {
		return instancia.toDTO(domain);
	}
}
