package br.com.barbearia.controller;

import br.com.barbearia.model.domain.Usuario;
import br.com.barbearia.model.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") Long usuarioID) {
		Optional<Usuario> usuario0p = usuarioRepository.findById(usuarioID);
		if (usuario0p.isPresent()) {
			return ResponseEntity.ok(usuario0p.get());
		}
		return ResponseEntity.notFound().build();
	}
}
