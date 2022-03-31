package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Volante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceVolante {
    Mono<Volante> save(Volante volante);

    Flux<Volante> findAll();

    Mono<Volante> delete(String id);

    Mono<Volante> update(String id, Volante volante);

    Mono<Volante> findById(String id);
}
