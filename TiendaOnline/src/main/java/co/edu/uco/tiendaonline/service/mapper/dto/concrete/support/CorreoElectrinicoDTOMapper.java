package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;


import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;



public class CorreoElectrinicoDTOMapper implements DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> {

	private static final DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain>
	instancia = new CorreoElectrinicoDTOMapper();

	private CorreoElectrinicoDTOMapper() {
		super();
	}

	@Override
	public CorreoElectronicoClienteDomain toDomain(CorreoElectronicoClienteDTO entity) {
		if (UtilObjeto.esNulo(entity)) {
			throw ServiceTiendaOnlineException.crear(
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toDomain en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion dominio a partir de un tipo de identificacion entity nula");
		}

		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),entity.isConfirmacionCorreoElectronico());
	}

	@Override
	public CorreoElectronicoClienteDTO toDTO(CorreoElectronicoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			throw ServiceTiendaOnlineException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004),
					"Se ha presentado un problema en el metodo toEntity en la clase TipoIdentifiacionDomain. No es posible mapear un tipo identificacion entity a partir de un tipo de identificacion domain nulo");

		}
		return CorreoElectronicoClienteDTO.crear(domain.getCorreoElectronico(),domain.isConfirmacionCorreoElectronico());
	}
		
	
	public static final CorreoElectronicoClienteDomain converToDomain(final CorreoElectronicoClienteDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoClienteDTO converToDTO(final CorreoElectronicoClienteDomain domain) {
		return instancia.toDTO(domain);
	}

	
}
