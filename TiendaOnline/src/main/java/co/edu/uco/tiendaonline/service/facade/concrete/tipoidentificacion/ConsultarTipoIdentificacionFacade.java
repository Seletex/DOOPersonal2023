package co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoidentificacionUseCase;

import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion.ConsultarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class ConsultarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO> {

	@Override
	public void execute(final TipoIdentificacionDTO dto) {
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.converToDomain(dto);// Desde el DTO con un nuevo mapper
		ConsultarTipoIdentificacionValidator.ejecutarValidacion(domain);

		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		try {
			daoFactory.iniciarTransaccion();
			final var useCAse = new RegistrarTipoidentificacionUseCase(daoFactory);
			useCAse.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (TiendaOnlineException excepcion) {
			daoFactory.cancelrTransaccion();
			throw excepcion;
		}catch (Exception excepcion) {
			throw ServiceTiendaOnlineException.crear(excepcion,
					"Se presento un problema inesparado tratando de registrar un Tipo identificacion",
					"Se presento un problema en el metodo Registrar Tipo identificacion de la clase Registrar Tipo Identificacion Facade. Revise la traza completa...");
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}

}
