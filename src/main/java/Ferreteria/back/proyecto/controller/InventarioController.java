package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Inventario;
import Ferreteria.back.proyecto.service.Impl.ServiceInventarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class InventarioController {
    @Autowired
    private ServiceInventarioImpl serviceInventario;

    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Inventario> saveInventario(@RequestBody Inventario inventario) {
        return this.serviceInventario.save(inventario);
    }

    @GetMapping(value = "/inventario")
    private Flux<Inventario> allInventarios() {
        return this.serviceInventario.findAll();
    }
}
