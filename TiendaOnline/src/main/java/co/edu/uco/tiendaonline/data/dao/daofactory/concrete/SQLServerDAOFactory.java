package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
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
			var cadenaConexion = "jdbc:sqlserver://<server>:<port>;encrypt=false;databaseName=<database>;user=<user>;password=<password>";
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (final SQLException excepcion) {
			
			throw DataTiendaOnlineException.crear(excepcion, CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004), CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000027));
		} catch (final Exception excepcion) {
			
			throw DataTiendaOnlineException.crear(excepcion, CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004), CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000028));
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	

	@Override
	public final ClienteDAO obtenerClienteDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
	
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000033));
		}

		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public final TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
		
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000034));
		}

		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public void cancelrTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
		
	}

}
