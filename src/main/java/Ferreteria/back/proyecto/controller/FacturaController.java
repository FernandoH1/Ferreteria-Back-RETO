package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Factura;
import Ferreteria.back.proyecto.service.Impl.ServiceFacturaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class FacturaController {

   @Autowired
    private ServiceFacturaImpl facturaService;

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> saveFactura(@RequestBody Factura factura) {
        return this.facturaService.save(factura);
    }

    @GetMapping(value = "/factura")
    private Flux<Factura> allFacturas() {
        return this.facturaService.findAll();
    }
}
