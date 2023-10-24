package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;

import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;


public class CorreoElectrinicoEntityMapper implements EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> {

	private static final EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain>
	instancia = new CorreoElectrinicoEntityMapper();

	private CorreoElectrinicoEntityMapper() {
		super();
	}

	@Override
	public CorreoElectronicoClienteDomain toDomain(CorreoElectronicoClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),entity.isConfirmacionCorreoElectronico());
	}

	@Override
	public CorreoElectronicoClienteEntity toEntity(CorreoElectronicoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return CorreoElectronicoClienteEntity.crear(domain.getCorreoElectronico(),domain.isConfirmacionCorreoElectronico());
	}
	
	public static final CorreoElectronicoClienteDomain converToDomain(final CorreoElectronicoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoClienteEntity converToEntity(final CorreoElectronicoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
