package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceCliente {
    Mono<Cliente> save(Cliente cliente);

    Flux<Cliente> findAll();

    Mono<Cliente> delete(String id);

    Mono<Cliente> update(String id, Cliente cliente);
}
