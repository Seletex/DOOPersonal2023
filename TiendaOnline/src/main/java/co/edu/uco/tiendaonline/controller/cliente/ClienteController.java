package co.edu.uco.tiendaonline.controller.cliente;

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
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ControllerTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;

import co.edu.uco.tiendaonline.service.facade.concrete.cliente.ConsultarClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.EliminarClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.RegistrarClienteFacade;


@RestController
@RequestMapping("/api/v1/cliente")
public final class ClienteController {

	@GetMapping("/dummy")
	public ClienteDTO obtenerDumy() {
		return ClienteDTO.crear();}
	
	
	
	@GetMapping
	public  final ResponseEntity<Respuesta<ClienteDTO>> consultar(@RequestBody ClienteDTO dto) {
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final ConsultarClienteFacade facade = new ConsultarClienteFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000085));
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			throw ControllerTiendaOnlineException.crear(excepcion, CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000061), CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000069));
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000085));
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
		
	}
	
	@GetMapping("/{id}")
	public final UUID consultarPorId(@PathVariable("id") UUID id) {
		return id;
	}
	@PostMapping
	public final ResponseEntity<Respuesta<ClienteDTO>> registrar(@RequestBody ClienteDTO dto) {
		 final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final RegistrarClienteFacade facade = new RegistrarClienteFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000058));
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add( CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000063));
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	}
	@PutMapping("/{id}")
	public final ResponseEntity<Respuesta<ClienteDTO>> modificar(@PathVariable("id") UUID id,@RequestBody ClienteDTO dto) {
		dto.setId(id);
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final ConsultarClienteFacade facade = new ConsultarClienteFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000059));
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000062));
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	
	}
		
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<ClienteDTO>> eliminar(@PathVariable("id") UUID id,@RequestBody ClienteDTO dto) {
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		HttpStatus codigoHttpStatus = HttpStatus.BAD_REQUEST;
		try {
			final EliminarClienteFacade facade = new EliminarClienteFacade();
			facade.execute(dto);
			codigoHttpStatus = HttpStatus.OK;
			respuesta.getMensajes().add( CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000060));
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensageUsuario());
			//TODO: Hacer Logging de la excepcion presentada
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add( CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000068));
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttpStatus);
	
	}
}
