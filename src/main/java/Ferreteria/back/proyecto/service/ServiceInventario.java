package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceInventario {
    Mono<Inventario> save(Inventario inventario);

    Flux<Inventario> findAll();

    Mono<Inventario> delete(String id);

    Mono<Inventario> update(String id, Inventario factura);

    Mono<Inventario> findById(String id);
}
