package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Cliente;
import Ferreteria.back.proyecto.model.Producto;
import Ferreteria.back.proyecto.service.Impl.ServiceProductoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductoController {
    @Autowired
    private ServiceProductoImpl serviceProducto;

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Producto> saveProducto(@RequestBody Producto producto) {
        return this.serviceProducto.save(producto);
    }

    @GetMapping(value = "/producto")
    private Flux<Producto> AllProductos() {
        return this.serviceProducto.findAll();
    }

    @DeleteMapping("/delete/producto/{id}")
    private Mono<ResponseEntity<Producto>> deleteProducto(@PathVariable("id") String id) {
        return this.serviceProducto.delete(id)
                .flatMap(Producto -> Mono.just(ResponseEntity.ok(Producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/producto/{id}")
    private Mono<ResponseEntity<Producto>> updateProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.serviceProducto.update(id, producto)
                .flatMap(producto1 -> Mono.just(ResponseEntity.ok(producto1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/producto/{id}")
    private Mono<Producto> searchProductoByID(@PathVariable("id") String id) {
        return this.serviceProducto.findById(id);
    }
}
