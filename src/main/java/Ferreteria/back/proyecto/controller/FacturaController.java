package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Factura;
import Ferreteria.back.proyecto.service.Impl.ServiceFacturaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaController {

   @Autowired
    private ServiceFacturaImpl facturaService;

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> saveFactura(@RequestBody Factura factura) {
       // factura.calcularPago();
        return this.facturaService.save(factura);
    }

    @GetMapping(value = "/factura")
    private Flux<Factura> allFacturas() {
        return this.facturaService.findAll();
    }

    @DeleteMapping("/delete/factura/{id}")
    private Mono<ResponseEntity<Factura>> deleteFactura(@PathVariable("id") String id) {
        return this.facturaService.delete(id)
                .flatMap(Factura -> Mono.just(ResponseEntity.ok(Factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/factura/{id}")
    private Mono<ResponseEntity<Factura>> updateFactura(@PathVariable("id") String id, @RequestBody Factura factura) {
        return this.facturaService.update(id, factura)
                .flatMap(factura1 -> Mono.just(ResponseEntity.ok(factura1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/factura/{id}")
    private Mono<Factura> searchFacturaByID(@PathVariable("id") String id) {
        return this.facturaService.findById(id);
    }

}
