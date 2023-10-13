package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		super(conexion);

	}

	@Override
	public final void crear(TipoIdentificacionEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado) ");
		sentencia.append("VALUES (?,?,?,?) ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			throw DataTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000036),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000037));
		} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000038),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039));
		}

	}

	@Override
	public final void modificar(TipoIdentificacionEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("UPDATE TipoIdentificacion ");
		sentencia.append("SET codigo=?, nombre=?, estado=? ");
		sentencia.append("WHERE id=? ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			throw DataTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000040),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000041));
			} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(excepcion,
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000042),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000043));
		}

	}

	@Override
	public final void eliminar(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("DELETE FROM TipoIdentificacion ");
		sentencia.append("WHERE id=?");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			throw DataTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000044),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000045));
			} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000046),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047));
		}

	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECTO id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");

		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		try (final var sentenciaPrepareda = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPrepareda.setObject(1, id);

			try (final var resultados = sentenciaPrepareda.executeQuery()) {
				if (resultados.next()) {
					final var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
							resultados.getString("nombre"), resultados.getBoolean("estado"));
					resultado = Optional.of(tipoIdentificacionEntity);
				}
			} catch (SQLException excepcion) {
				throw DataTiendaOnlineException.crear(excepcion,
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000048),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000049));
			}
		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final Exception excepcion) {

			throw DataTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000050),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000051));
		}

		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
