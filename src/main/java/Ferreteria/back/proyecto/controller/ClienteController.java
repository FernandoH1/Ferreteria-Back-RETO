package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Cliente;
import Ferreteria.back.proyecto.service.Impl.ServiceClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private Mono<Cliente> save(@RequestBody Cliente cliente) {
        return this.serviceCliente.save(cliente);
    }

    @GetMapping(value = "/cliente")
    private Flux<Cliente> findAll() {
        return this.serviceCliente.findAll();
    }


}
