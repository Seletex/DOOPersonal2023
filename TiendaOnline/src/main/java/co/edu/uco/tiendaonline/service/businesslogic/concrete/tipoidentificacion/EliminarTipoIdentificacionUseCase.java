package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;


import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoidentificacionEntityMapper;

public class EliminarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {

	private DAOFactory factoria;

	@Override
	public void execute(TipoIdentificacionDomain domain) {
		setFactoria(factoria);

		// 1. Validar integridad de datos(Tipo de Dato, logitud, obligatoriedad,
		// formato,rango)

		validarExistenciaTipoIdentificacionMismoId(domain.getId());

		// 5 Registrar un nuevo tipo identificacion
		eliminarTipoidentificacion(domain);
	}

	private final void eliminarTipoidentificacion(final TipoIdentificacionDomain domain) {
		final var entity = TipoidentificacionEntityMapper.converToEntity(domain);
		getTipoIdentificacionDAO().eliminar(entity.getId());
	}

	private final void validarExistenciaTipoIdentificacionMismoId(final UUID id) {
		
		final var resultado = getTipoIdentificacionDAO().consultar(
				TipoidentificacionEntityMapper.converToEntity(TipoIdentificacionDomain.crear(id, null, null, false)));

		if (!resultado.isEmpty()) {
			throw ServiceTiendaOnlineException.crear("Ya existe un tipo de identificacion con ese mismo codigo");
		}
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			throw ServiceTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de llevar  a cabo el registro de la información de un nuevo tipo de identificación...",
					"Se ha presentado un problema en el metodo setFactororia en la clase RegistrarTipoidentificacionUseCase, debido a que la factoria está nula...");
		}

		this.factoria = factoria;
	}

	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
}
