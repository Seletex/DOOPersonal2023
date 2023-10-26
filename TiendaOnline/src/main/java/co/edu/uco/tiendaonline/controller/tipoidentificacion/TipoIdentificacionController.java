package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionController {

	@GetMapping("/dummy")
	public TipoIdentificacionDTO obtenerDumy() {
		return TipoIdentificacionDTO.crear();}
	
	
	
	@GetMapping
	public  final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping("/{id}")
	public final UUID consultarPorId(@PathVariable("id") UUID id) {
		return id;
	}
	@PostMapping
	public final TipoIdentificacionDTO registrar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	@PutMapping("/{id}")
	public final TipoIdentificacionDTO modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
		
	
	@DeleteMapping("/{id}")
	public final UUID eliminar(@PathVariable("id") UUID id) {
		return id;
	}
}

