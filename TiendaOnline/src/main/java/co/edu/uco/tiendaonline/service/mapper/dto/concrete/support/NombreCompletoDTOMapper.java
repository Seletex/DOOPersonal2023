package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;



import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public class NombreCompletoDTOMapper implements DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> {

	private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain>
	instancia = new NombreCompletoDTOMapper();

	private NombreCompletoDTOMapper() {
		super();
	}

	@Override
	public NombreCompletoClienteDomain toDomain(NombreCompletoClienteDTO entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return NombreCompletoClienteDomain.crear(entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteDTO toDTO(NombreCompletoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return NombreCompletoClienteDTO.crear(domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido());
	}
	
	public static final NombreCompletoClienteDomain converToDomain(final NombreCompletoClienteDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NombreCompletoClienteDTO converToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDTO(domain);
	}
}
