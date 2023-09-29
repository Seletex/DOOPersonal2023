package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO{

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		super(conexion);
		
	}

	@Override
	public final void crear(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
