package co.edu.uco.tiendaonline.data.dao.base;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLDAO {

	private Connection conexion;

	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}

	private final void setConexion(final Connection conexion) {

		try {
			if (conexion != null && !conexion.isClosed()) {
				System.out.println("La conexion esta abierta");
			}
		} catch (final SQLException exception) {
			throw new RuntimeException("Falla en la conexion");
		}
	}

	protected final Connection getConexion() {
		return conexion;
	}

}
