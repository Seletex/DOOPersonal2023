package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.data.entity.support.NumeroCelularClienteEntity;

import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroCelularClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public class NumeroCelularEntityMapper implements EntityMapper<NumeroCelularClienteEntity, NumeroCelularClienteDomain> {

	private static final EntityMapper<NumeroCelularClienteEntity, NumeroCelularClienteDomain>
	instancia = new NumeroCelularEntityMapper();

	private NumeroCelularEntityMapper() {
		super();
	}

	@Override
	public NumeroCelularClienteDomain toDomain(NumeroCelularClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return NumeroCelularClienteDomain.crear(entity.getNumeroCelular(), entity.getNumeroCelularConfirmado());
	}

	@Override
	public NumeroCelularClienteEntity toEntity(NumeroCelularClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return NumeroCelularClienteEntity.crear(domain.getNumeroCelular(),domain.getNumeroCelularConfirmado());
	}
	
	public static final NumeroCelularClienteDomain converToDomain(final NumeroCelularClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroCelularClienteEntity converToEntity(final NumeroCelularClienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
