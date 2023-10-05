package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;

public class UtilSQL {

	private UtilSQL() {
		super();
	}

	public static final boolean conexionAbierta(final Connection conexion) {
		try {
			return UtilObjeto.esNulo(conexion) && !conexion.isClosed();
		} catch (SQLException exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"No es posible validar si una conexion esta abierta cuando esta nula");
		} catch (Exception exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000005));
		}
	}

	public static final void cerrarConexion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"No es posible cerrar una conexion que ya esta nula");

		}
		try {
			if (!conexionAbierta(conexion)) {
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						"No es posible cerrar una conexion que ya esta cerrada");

			}
			conexion.close();
		} catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema tratando de cerrar la conexion SQL de tipo SQLException");
		} catch (Exception exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema inesperado trantado de cerrar la conexion SQL");
		}
	}
	public static final void iniciarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"No es posible iniciar una transaccion con una conexion que ya esta nula");

		}
		try {
			if (!conexionAbierta(conexion)) {
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						"No es posible iniciar una transaccion con una conexion que ya esta cerrada");

			}
			if (conexion.getAutoCommit()) {
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						"No es posible iniciar una transaccion con una transaccion que ya ha sido iniciada");

			}
			conexion.close();
		} catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema tratando de cerrar la conexion SQL de tipo SQLException");
		} catch (Exception exception) {
			throw CrossCuttingTiendaOnlineException.crear(exception,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema inesperado trantado de cerrar la conexion SQL");
		}
	}
}
