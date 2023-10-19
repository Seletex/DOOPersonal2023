package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public class TipoidentificacionEntityMapper
		implements EntityMapper<TipoIdentificacionEntity, TipoIdentificacionDomain> {

	private static final EntityMapper<TipoIdentificacionEntity, TipoIdentificacionDomain>
	instancia = new TipoidentificacionEntityMapper();

	private TipoidentificacionEntityMapper() {
		super();
	}

	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return TipoIdentificacionDomain.crear(entity.getId(), entity.getCodigo(), entity.getNombre(),
				entity.isEstado());
	}

	@Override
	public TipoIdentificacionEntity toEntity(TipoIdentificacionDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return TipoIdentificacionEntity.crear(domain.getId(), domain.getCodigo(), domain.getNombre(),
				domain.isEstado());
	}
	
	public static final TipoIdentificacionDomain converToDomain(final TipoIdentificacionEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoIdentificacionEntity converToEntity(final TipoIdentificacionDomain domain) {
		return instancia.toEntity(domain);
	}

}
