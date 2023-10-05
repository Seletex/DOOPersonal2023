package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;

	public SQLServerDAOFactory() {
		abrirConexion();
	}

	
	@Override
	protected final void abrirConexion() {

		try {
			if (conexion != null && !conexion.isClosed()) {
				System.out.println("La conexion esta abierta");
			}
		} catch (final SQLException exception) {
			throw new RuntimeException("Falla en la conexion");
		}

	}

	@Override
	public final void cerrarConexion() {
		try {
			if (!conexion.isClosed()) {
				System.out.println("La conexion ya se ha cerrado");
			}
			conexion.close();
		}

		catch (final SQLException exception) {
			throw new RuntimeException("Conexion cerrada");
		}

	}

	@Override
	public final void iniciarTransaccion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				System.out.println("La conexion esta abierta");
			}
			conexion.setAutoCommit(false);

		} catch (final SQLException exception) {
			throw new RuntimeException("Ha ocurrido un problema a la hora de iniciar la transaccion");
		}

	}

	@Override
	public final void confirmarTransaccion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				System.out.println("La conexion esta abierta");
			}
			conexion.setAutoCommit(true);
		}

		catch (final SQLException exception) {
			throw new RuntimeException("Ha ocurrido un error inesperado a la hora de realizar la transaccion");
		}
	}

	@Override
	public final void cancelrTransaccion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				System.out.println("La conexion esta abierta");
			}
			conexion.rollback();
		}

		catch (final SQLException exception) {
			throw new RuntimeException("Ha ocurrido un error inesperado a la hora de realizar la transaccion");
		}
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {

		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {

		return new TipoIdentificacionSQLServerDAO(conexion);
	}

}
