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

		if (UtilObjeto.esNulo(conexion)) {

			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000007));
		}

		try {
			return !conexion.isClosed();
		} catch (final SQLException excepcion) {

			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000005));
		} catch (final Exception excepcion) {

			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000006));
		}
	}

	public static final void cerrarConexion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {

			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000026));
		}

		try {
			if (!conexionAbierta(conexion)) {

				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000008));
			}

			conexion.close();
		} catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
		
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000009));
		} catch (final Exception excepcion) {
			
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000010));
		}
	}

	public static final void iniciarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
	
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000011));
		}

		try {
			if (!conexionAbierta(conexion)) {

				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000012));
			}

			if (!conexion.getAutoCommit()) {
			
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000013));
			}

			conexion.setAutoCommit(false);
		} catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
		
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000014));
		} catch (final Exception excepcion) {
		
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000015));
		}
	}

	public static final void confirmarTransaccion(final Connection conexion) {

		if (UtilObjeto.esNulo(conexion)) {
		
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000016));
		}

		try {
			if (!conexionAbierta(conexion)) {
				
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000017));
			}

			if (conexion.getAutoCommit()) {
		
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000018));
			}

			conexion.commit();
		} catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
	
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000019));
		} catch (final Exception excepcion) {
	
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000020));
		}
	}

	public static final void cancelarTransaccion(final Connection conexion) {

		if (UtilObjeto.esNulo(conexion)) {
		
			throw CrossCuttingTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M000000021));
		}

		try {
			if (!conexionAbierta(conexion)) {
	
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000022));
			}

			if (conexion.getAutoCommit()) {
			
				throw CrossCuttingTiendaOnlineException.crear(
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000023));
			}

			conexion.rollback();
		} catch (final CrossCuttingTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
		
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000024));
		} catch (final Exception excepcion) {
		
			throw CrossCuttingTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000025));
		}
	}
}
