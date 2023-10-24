package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;

import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;

import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.RegistrarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;


public class RegistrarClienteUseCase implements UseCase<ClienteDomain> {

	private DAOFactory factoria;

	public RegistrarClienteUseCase(DAOFactory factoria) {

		setFactoria(factoria);

	}

	@Override
	public void execute(ClienteDomain domain) {
		// 1. Validar integridad de datos(Tipo de Dato, logitud, obligatoriedad,
		// formato,rango)
		RegistrarClienteValidator.ejecutarValidacion(domain);
		// 4. No debe de existir otro tipo de identificacion con el mismo nombre
		validarNoExistnciaClienteConMismoNombre(domain.getTipoIdentificacion(),domain.getIdentificacion());
		// 2. No debe de existir otro tipo de identificacion con l mismo identificador
		domain = obtenerIdentificacirCliente(domain);
		// 5 Registrar un nuevo tipo identificacion
		registrarNuevoCliente(domain);
	}

	private final void registrarNuevoCliente(final ClienteDomain domain) {
		final var entity = ClienteEntityMapper.converToEntity(domain);
		getClienteDAO().crear(entity);
	}

	private final void validarNoExistnciaClienteConMismoNombre(final TipoIdentificacionDomain tipoIdentificacionDomain,final String identificacion) {


		final var resultado = getClienteDAO().consultar(ClienteEntityMapper
				.converToEntity(ClienteDomain.crear(null, tipoIdentificacionDomain, identificacion, null,null,null,null)));

		if (!resultado.isEmpty()) {
			throw ServiceTiendaOnlineException.crear("Ya existe un tipo de identificacion con ese mismo nombre");
		}
	}

	

	private final ClienteDomain obtenerIdentificacirCliente(
			final ClienteDomain domain) {
		Optional<ClienteEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();

			optional = getClienteDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		return ClienteDomain.crear(uuid, domain.getTipoIdentificacion(), domain.getIdentificacion(), domain.getNombreCompleto(),
				domain.getCorreoElectronico(),domain.getNumeroCelular(),domain.getFechaNacimineto());
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

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}

}
