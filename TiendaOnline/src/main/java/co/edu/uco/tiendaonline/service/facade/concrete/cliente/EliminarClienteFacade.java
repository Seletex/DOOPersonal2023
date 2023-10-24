package co.edu.uco.tiendaonline.service.facade.concrete.cliente;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente.EliminarClienteUseCase;

import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.EliminarClienteValidator;

import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;

import co.edu.uco.tiendaonline.service.dto.ClienteDTO;

import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.ClienteDTOMapper;


public final class EliminarClienteFacade implements Facade<ClienteDTO> {

	@Override
	public void execute(final ClienteDTO dto) {
		final ClienteDomain domain = ClienteDTOMapper.converToDomain(dto);// Desde el DTO con un nuevo mapper
		EliminarClienteValidator.ejecutarValidacion(domain);

		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		try {
			daoFactory.iniciarTransaccion();
			final var useCAse = new EliminarClienteUseCase(daoFactory);
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