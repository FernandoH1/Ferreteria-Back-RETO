package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.service.Impl.ServiceProveedorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
}
