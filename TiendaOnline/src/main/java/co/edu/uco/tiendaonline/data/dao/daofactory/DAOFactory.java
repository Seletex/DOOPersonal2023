package co.edu.uco.tiendaonline.data.dao.daofactory;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;


public abstract class DAOFactory {
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factory) {
		switch (factory) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
			
		}
		case POSTGRESQL: {
		
			throw new RuntimeException("Fatoria no soportada");
		}
		case ORACLE: {
			
			throw new RuntimeException("Fatoria no soportada");
		}
		default:
			throw new RuntimeException("Fatoria no soportada");
		}
	}
	
	protected abstract void abrirConexion() ;
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelrTransaccion();
	
	public abstract ClienteDAO obtenerClienteDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();

}
