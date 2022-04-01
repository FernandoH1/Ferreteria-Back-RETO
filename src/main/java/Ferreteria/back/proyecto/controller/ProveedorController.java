package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Inventario;
import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.service.Impl.ServiceProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProveedorController {
    @Autowired
    private ServiceProveedorImpl serviceProveedor;

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
        return this.serviceProveedor.save(proveedor);
    }

    @GetMapping(value = "/proveedor")
    private Flux<Proveedor> allProveedores() {
        return this.serviceProveedor.findAll();
    }

    @DeleteMapping("/delete/proveedor/{id}")
    private Mono<ResponseEntity<Proveedor>> deleteProveedor(@PathVariable("id") String id) {
        return this.serviceProveedor.delete(id)
                .flatMap(Inventario -> Mono.just(ResponseEntity.ok(Inventario)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/proveedor/{id}")
    private Mono<ResponseEntity<Proveedor>> updateProveedor(@PathVariable("id") String id, @RequestBody Proveedor proveedor) {
        return this.serviceProveedor.update(id, proveedor)
                .flatMap(proveedor1 -> Mono.just(ResponseEntity.ok(proveedor1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/proveedor/{id}")
    private Mono<Proveedor> searchProveedorByID(@PathVariable("id") String id) {
        return this.serviceProveedor.findById(id);
    }
}
