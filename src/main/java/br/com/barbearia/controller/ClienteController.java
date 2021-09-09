package br.com.barbearia.controller;

import br.com.barbearia.model.domain.Cliente;
import br.com.barbearia.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Long clienteId) {
        Optional<Cliente> clienteOp = clienteRepository.findById(clienteId);
        if (clienteOp.isPresent()) {
            return ResponseEntity.ok(clienteOp.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity criar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente.getId());
    }

    @PutMapping("/")
    public ResponseEntity atualizar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Long clienteId) {
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.ok().build();
    }
}
