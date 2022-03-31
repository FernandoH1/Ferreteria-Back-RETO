package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceProducto {
    Mono<Producto> save(Producto producto);

    Flux<Producto> findAll();

    Mono<Producto> delete(String id);

    Mono<Producto> update(String id, Producto producto);

    Mono<Producto> findById(String id);
}
