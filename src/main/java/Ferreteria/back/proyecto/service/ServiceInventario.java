package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceInventario {
    Mono<Inventario> save(Inventario inventario);

    Flux<Inventario> findAll();
}
