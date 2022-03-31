package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Proveedor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceProveedor {
    Mono<Proveedor> save(Proveedor proveedor);

    Flux<Proveedor> findAll();
}
