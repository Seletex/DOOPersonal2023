package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
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
			throw DataTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema de tipo SQLException en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");
		} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema inesperado de tipo Exception en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");

		}

	}

	@Override
	public final void modificar(TipoIdentificacionEntity entity) {
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
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema de tipo SQLException en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");
		} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(excepcion,
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema inesperado de tipo Exception en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");

		}

	}

	@Override
	public final void eliminar(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado) ");
		sentencia.append("VALUES (?,?,?,?) ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			throw DataTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema de tipo SQLException en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");
		} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema inesperado de tipo Exception en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");

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
						"Se ha presentado un problema tratando de consultar la información del Tipo de Identificación por identificador deseado...",
						"Se ha presentado un problema de tipo SQLException en el método consultar ById la clase TipoIdentificacion tratando de recuperar los datos del TipoIdentifiacin deseado. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");

			}
		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final Exception excepcion) {

			throw DataTiendaOnlineException.crear(
					"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación",
					"Se ha presentado un problema inesperado de tipo Exception tratando de preparar la sentencia SQL de la consulta del tipo identificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio");

		}

		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
