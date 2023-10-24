package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.CorreoElectrinicoDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NombreCompletoDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NumeroCelularDTOMapper;




public class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain> {

	private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();

	private ClienteDTOMapper() {
		super();
	}

	@Override
	public ClienteDomain toDomain(ClienteDTO entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return ClienteDomain.crear(entity.getId(),
				TipoIdentificacionDTOMapper.converToDomain(entity.getTipoIdentificacion()),
				entity.getIdentificacion(),
				NombreCompletoDTOMapper.converToDomain(entity.getNombreCompleto()),
				CorreoElectrinicoDTOMapper.converToDomain(entity.getCorreoElectronico()),
				NumeroCelularDTOMapper.converToDomain(entity.getNumeroCelular()),
				entity.getFechaNacimineto());
	}

	@Override
	public ClienteDTO toDTO(ClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return ClienteDTO.crear(domain.getId(),
				TipoIdentificacionDTOMapper.converToDTO(domain.getTipoIdentificacion()),
				domain.getIdentificacion(),
				NombreCompletoDTOMapper.converToDTO(domain.getNombreCompleto()),
				CorreoElectrinicoDTOMapper.converToDTO(domain.getCorreoElectronico()),
				NumeroCelularDTOMapper.converToDTO(domain.getNumeroCelular()),
				domain.getFechaNacimineto());
	}

	public static final ClienteDomain converToDomain(final ClienteDTO entity) {
		return instancia.toDomain(entity);
	}

	public static final ClienteDTO converToDTO( ClienteDomain domain) {
		return instancia.toDTO(domain);
	}
}
