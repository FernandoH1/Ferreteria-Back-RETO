package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Factura;
import Ferreteria.back.proyecto.model.Inventario;
import Ferreteria.back.proyecto.model.Producto;
import Ferreteria.back.proyecto.service.Impl.ServiceInventarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @DeleteMapping("/delete/inventario/{id}")
    private Mono<ResponseEntity<Inventario>> deleteInventario(@PathVariable("id") String id) {
        return this.serviceInventario.delete(id)
                .flatMap(Inventario -> Mono.just(ResponseEntity.ok(Inventario)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/inventario/{id}")
    private Mono<ResponseEntity<Inventario>> updateInventario(@PathVariable("id") String id, @RequestBody Inventario inventario) {
        return this.serviceInventario.update(id, inventario)
                .flatMap(inventario1 -> Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/inventario/{id}")
    private Mono<Inventario> searchInventarioByID(@PathVariable("id") String id) {
        return this.serviceInventario.findById(id);
    }

}
