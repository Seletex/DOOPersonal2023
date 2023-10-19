package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;


import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoidentificacionEntityMapper;

public class RegistrarTipoidentificacionUseCase implements UseCase<TipoIdentificacionDomain> {

	private DAOFactory factoria;

	public RegistrarTipoidentificacionUseCase(DAOFactory factoria) {

		setFactoria(factoria);

	}

	@Override
	public void execute(TipoIdentificacionDomain domain) {
		// 1. Validar integridad de datos(Tipo de Dato, logitud, obligatoriedad,
		// formato,rango)
		
		
		// 3. No debe de existir otro tipo de identificacion con el mismo codigo
		validarNoexistenciaTipoIdentificacionMismoCodigo(domain.getCodigo());
		// 4. No debe de existir otro tipo de identificacion con el mismo nombre
		validarNoExistnciaTipoIdentificacionConMismoNombre(domain.getNombre());
		// 2. No debe de existir otro tipo de identificacion con l mismo identificador
				domain=obtenerIdentificacirTipoIdentificacion(domain);
		// 5 Registrar un nuevo tipo identificacion
		registrarNuevoTipoidentificacion(domain);
	}

	private final void registrarNuevoTipoidentificacion(final TipoIdentificacionDomain domain) {
		final var entity = TipoidentificacionEntityMapper.converToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}

	private final void validarNoExistnciaTipoIdentificacionConMismoNombre(final String nombre) {
		// TODO: ¿Como lograr que esto no quede tan feo????
		final var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		final var entity = TipoidentificacionEntityMapper.converToEntity(domain);
		final var resultado = getTipoIdentificacionDAO().consultar(entity);

		if (!resultado.isEmpty()) {
			throw ServiceTiendaOnlineException.crear("Ya existe un tipo de identificacion con ese mismo nombre");
		}
	}

	private final void validarNoexistenciaTipoIdentificacionMismoCodigo(final String codigo) {
		// TODO: ¿Como lograr que esto no quede tan feo????
		final var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
		final var entity = TipoidentificacionEntityMapper.converToEntity(domain);
		final var resultado = getTipoIdentificacionDAO().consultar(entity);

		if (!resultado.isEmpty()) {
			throw ServiceTiendaOnlineException.crear("Ya existe un tipo de identificacion con ese mismo codigo");
		}
	}

	

	private final TipoIdentificacionDomain obtenerIdentificacirTipoIdentificacion(final TipoIdentificacionDomain domain) {
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		do {
		 uuid=UUID.randomUUID();
			
			optional= getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
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
