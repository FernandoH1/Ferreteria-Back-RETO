package Ferreteria.back.proyecto.service;

import Ferreteria.back.proyecto.model.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceFactura {
    Mono<Factura> save(Factura factura);

    Flux<Factura> findAll();

    Mono<Factura> delete(String id);

    Mono<Factura> update(String id, Factura factura);

    Mono<Factura> findById(String id);
}
