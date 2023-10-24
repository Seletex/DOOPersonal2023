package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;



import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;

import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.ModificarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;


public class ModificarClienteUseCase implements UseCase<ClienteDomain>{

	private DAOFactory factoria;
	


	public ModificarClienteUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(ClienteDomain domain) {
		// 1. Validar integridad de datos(Tipo de Dato, logitud, obligatoriedad,
		// formato,rango)
ModificarClienteValidator.ejecutarValidacion(domain);
		// 4. No debe de existir otro tipo de identificacion con el mismo nombre
		validarNoExistnciaClienteConMismoNombre(domain.getTipoIdentificacion(), domain.getIdentificacion());
		// 2. No debe de existir otro tipo de identificacion con l mismo identificador

		// 5 Registrar un nuevo tipo identificacion
		modificarNuevoCliente(domain);
	}

	private final void modificarNuevoCliente(final ClienteDomain domain) {
		final var entity = ClienteEntityMapper.converToEntity(domain);
		getClienteDAO().modificar(entity);
	}

	private final void validarNoExistnciaClienteConMismoNombre(final TipoIdentificacionDomain tipoIdentificacionDomain,
			final String identificacion) {


		final var resultado = getClienteDAO().consultar(ClienteEntityMapper.converToEntity(
				ClienteDomain.crear(null, tipoIdentificacionDomain, identificacion, null, null, null, null)));

		if (!resultado.isEmpty()) {
			throw ServiceTiendaOnlineException.crear("Ya existe un tipo de identificacion con ese mismo nombre");
		}
	}

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
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

	
}
