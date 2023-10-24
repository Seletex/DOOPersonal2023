package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.data.entity.ClienteEntity;

import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.CorreoElectrinicoEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NombreCompletoEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NumeroCelularEntityMapper;

public class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain> {

	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();

	private ClienteEntityMapper() {
		super();
	}

	@Override
	public ClienteDomain toDomain(ClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return ClienteDomain.crear(entity.getId(),
				TipoidentificacionEntityMapper.converToDomain(entity.getTipoIdentificacion()),
				entity.getIdentificacion(),
				NombreCompletoEntityMapper.converToDomain(entity.getNombreCompleto()),
				CorreoElectrinicoEntityMapper.converToDomain(entity.getCorreoElectronico()),
				NumeroCelularEntityMapper.converToDomain(entity.getNumeroCelular()),
				entity.getFechaNacimineto());
	}

	@Override
	public ClienteEntity toEntity(ClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return ClienteEntity.crear(domain.getId(),
				TipoidentificacionEntityMapper.converToEntity(domain.getTipoIdentificacion()),
				domain.getIdentificacion(),
				NombreCompletoEntityMapper.converToEntity(domain.getNombreCompleto()),
				CorreoElectrinicoEntityMapper.converToEntity(domain.getCorreoElectronico()),
				NumeroCelularEntityMapper.converToEntity(domain.getNumeroCelular()),
				domain.getFechaNacimineto());
	}

	public static final ClienteDomain converToDomain(final ClienteEntity entity) {
		return instancia.toDomain(entity);
	}

	public static final ClienteEntity converToEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
