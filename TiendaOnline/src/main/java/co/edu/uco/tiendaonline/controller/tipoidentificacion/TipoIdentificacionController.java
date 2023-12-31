package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.ConsultarTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.EliminarTipoIdentificacionFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionController {

	@GetMapping("/dummy")
	public TipoIdentificacionDTO obtenerDumy() {
		return TipoIdentificacionDTO.crear();}
	
	
	
	@GetMapping
	public  final ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar(@RequestBody TipoIdentificacionDTO dto) {
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final ConsultarTipoIdentificacionFacade facade = new ConsultarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( "El tipo de identificacion fue registrado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el tipo de identificacion deseado ");
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
		
	}
	
	@GetMapping("/{id}")
	public final UUID consultarPorId(@PathVariable("id") UUID id) {
		return id;
	}
	@PostMapping
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		 final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( "El tipo de identificacion fue registrado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el tipo de identificacion deseado ");
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	}
	@PutMapping("/{id}")
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final ConsultarTipoIdentificacionFacade facade = new ConsultarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( "El tipo de identificacion fue modifcado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de modificar el tipo de identificacion deseado ");
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	
	}
		
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		final Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final EliminarTipoIdentificacionFacade facade = new EliminarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( "El tipo de identificacion fue eliminado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de eliminar el tipo de identificacion deseado ");
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	
	}
}

