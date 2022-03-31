package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Cliente;
import Ferreteria.back.proyecto.service.Impl.ServiceClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ClienteController {

    @Autowired
    private ServiceClienteImpl serviceCliente;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return this.serviceCliente.save(cliente);
    }

    @GetMapping(value = "/cliente")
    private Flux<Cliente> AllClientes() {
        return this.serviceCliente.findAll();
    }

    @DeleteMapping("/delete/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> deleteCliente(@PathVariable("id") String id) {
        return this.serviceCliente.delete(id)
                .flatMap(Cliente -> Mono.just(ResponseEntity.ok(Cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/cliente/{id}")
    private Mono<ResponseEntity<Cliente>> updateCliente(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return this.serviceCliente.update(id, cliente)
                .flatMap(cliente1 -> Mono.just(ResponseEntity.ok(cliente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/cliente/{id}")
    private Mono<Cliente> searchClienteByID(@PathVariable("id") String id) {
            return this.serviceCliente.findById(id);
    }


}
