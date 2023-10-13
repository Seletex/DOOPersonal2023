package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroCelularClienteEntity;

public class ClienteSQLServerDAO extends SQLDAO implements ClienteDAO {

	public ClienteSQLServerDAO(Connection conexion) {
		super(conexion);

	}

	@Override
	public final void crear(ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO Cliente (id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroCelular, fechaNacimiento) ");
		sentencia.append("VALUES (?,?,?,?,?,?,?) ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getTipoIdentificacion());
			sentenciaPreparada.setString(3, entity.getIdentificacion());
			sentenciaPreparada.setObject(4, entity.getNombreCompleto());
			sentenciaPreparada.setObject(5, entity.getCorreoElectronico());
			sentenciaPreparada.setObject(6, entity.getNumeroCelular());
			sentenciaPreparada.setDate(7, entity.getFechaNacimineto());

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
	public final void modificar(ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("UPDATE TipoIdentificacion ");
		sentencia.append("SET tipoIdentificacion=?, identificacion=?, nombreCompleto=?, correoElectronico=?, numeroCelular=?, fechaNacimiento=? ");
		sentencia.append("WHERE id=? ");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(2, entity.getTipoIdentificacion());
			sentenciaPreparada.setString(3, entity.getIdentificacion());
			sentenciaPreparada.setObject(4, entity.getNombreCompleto());
			sentenciaPreparada.setObject(5, entity.getCorreoElectronico());
			sentenciaPreparada.setObject(6, entity.getNumeroCelular());
			sentenciaPreparada.setDate(7, entity.getFechaNacimineto());

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
		sentencia.append("DELETE FROM Cliente ");
		sentencia.append("WHERE id=?");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			throw DataTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000044),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000045));
		} catch (final Exception excepcion) {
			throw DataTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000046),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047));
		}

	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append(
				"SELECTO id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroCelular, fechaNacimiento ");
		sentencia.append("FROM Cliente ");
		sentencia.append("WHERE id = ? ");

		Optional<ClienteEntity> resultado = Optional.empty();
		try (final var sentenciaPrepareda = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPrepareda.setObject(1, id);

			try (final var resultados = sentenciaPrepareda.executeQuery()) {
				if (resultados.next()) {
					final var clienteEntity = ClienteEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()),
							resultados.getObject("tipoIdentificacion", TipoIdentificacionEntity.class),
							resultados.getString("identificacion"),
							resultados.getObject("nombreCompleto", NombreCompletoClienteEntity.class),
							(resultados.getObject("correoElectronico", CorreoElectronicoClienteEntity.class)),
							resultados.getObject("numeroCelular", NumeroCelularClienteEntity.class),
							resultados.getDate("fechaNacimiento"));
					resultado = Optional.of(clienteEntity);
				}
			} catch (SQLException excepcion) {
				throw DataTiendaOnlineException.crear(excepcion,
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000048),
						CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000049));
			}
		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final Exception excepcion) {

			throw DataTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000050),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000051));
		}

		return resultado;
	}

	@Override
	public final List<ClienteEntity> consultar(ClienteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
