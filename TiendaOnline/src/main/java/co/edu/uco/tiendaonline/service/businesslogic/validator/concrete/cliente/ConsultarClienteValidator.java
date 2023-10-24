package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;


import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.FechaNacimientoValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdentificacionClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.correo.ConfirmacionCorreoElectronicoValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.correo.CorreoCorreoElectronicoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.nombre.PrimerApellidoNombreCompletoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.nombre.PrimerNombreNombreCompletoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.nombre.SegundoApellidoNombreCompletoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.nombre.SegundoNombreNombreCompletoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.numerocelular.CelularNumeroCelularValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.support.numerocelular.ConfirmarNumeroCelularValidationRule;

import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public class ConsultarClienteValidator implements Validator<ClienteDomain>{

	private static final Validator<ClienteDomain> instancia = new ConsultarClienteValidator();
	private ConsultarClienteValidator() {
		
	}
	
	public static final void ejecutarValidacion(final ClienteDomain dato) {
		instancia.execute(dato);
	}
	
	@Override
	public void execute(final ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		IdClienteValidationRule.ejecutarValidacion(data.getId());
		TipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoIdentificacion());
		IdentificacionClienteValidationRule.ejecutarValidacion(data.getIdentificacion());
		PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getPrimerNombre());
		SegundoNombreNombreCompletoClienteValidationRule
				.ejecutarValidacion(data.getNombreCompleto().getSegundoNombre());
		PrimerApellidoNombreCompletoClienteValidationRule
				.ejecutarValidacion(data.getNombreCompleto().getPrimerApellido());
		SegundoApellidoNombreCompletoClienteValidationRule
				.ejecutarValidacion(data.getNombreCompleto().getSegundoApellido());
		CorreoCorreoElectronicoClienteValidationRule
				.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
		ConfirmacionCorreoElectronicoValidationRule
				.ejecutarValidacion(data.getCorreoElectronico().isConfirmacionCorreoElectronico());
		CelularNumeroCelularValidationRule.ejecutarValidacion(data.getNumeroCelular().getNumeroCelular());
		ConfirmarNumeroCelularValidationRule.ejecutarValidacion(data.getNumeroCelular().getNumeroCelularConfirmado());
		FechaNacimientoValidationRule.ejecutarValidacion(data.getFechaNacimineto());
		
	}
	
	

}
