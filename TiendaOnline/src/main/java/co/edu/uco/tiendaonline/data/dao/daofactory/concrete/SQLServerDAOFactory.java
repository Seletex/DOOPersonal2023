package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory{

	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	protected final void abrirConexion() {
		//TODO: Your homework will be to obtain connection with SQL server
		conexion=null;
		
	}

	@Override
	public final void cerrarConexion() {
		//TODO Your Homework will to be obtain to clase connection
		
	}

	@Override
	public final void iniciarTransaccion() {
		//TODO To init TRansaction
		
	}

	@Override
	public final void confirmarTransaccion() {
		//TODO: Your Homework to be obtain commit transaction
	}

	@Override
	public final void cancelrTransaccion() {
		//TODO Homework
		
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
