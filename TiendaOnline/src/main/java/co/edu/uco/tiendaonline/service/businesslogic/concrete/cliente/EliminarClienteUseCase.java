package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;



import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;

import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.ClienteDomain;

import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;


public class EliminarClienteUseCase implements UseCase<ClienteDomain> {

	private DAOFactory factoria;

	@Override
	public void execute(ClienteDomain domain) {
		setFactoria(factoria);

		// 1. Validar integridad de datos(Tipo de Dato, logitud, obligatoriedad,
		// formato,rango)

	
		// 5 Registrar un nuevo tipo identificacion
		eliminarTipoidentificacion(domain);
	}

	private final void eliminarTipoidentificacion(final ClienteDomain domain) {
		final var entity = ClienteEntityMapper.converToEntity(domain);
		getTipoIdentificacionDAO().eliminar(entity.getId());
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

	private final ClienteDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerClienteDAO();
	}
}
