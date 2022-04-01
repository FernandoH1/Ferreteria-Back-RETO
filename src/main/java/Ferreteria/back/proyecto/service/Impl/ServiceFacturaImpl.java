package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.model.Factura;
import Ferreteria.back.proyecto.repository.FacturaRepository;
import Ferreteria.back.proyecto.service.ServiceFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceFacturaImpl implements ServiceFactura {
    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public Mono<Factura> save(Factura factura) {
        return this.facturaRepository.save(factura);
    }

    @Override
    public Flux<Factura> findAll() {
        return this.facturaRepository.findAll();
    }

    @Override
    public Mono<Factura> delete(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap(p -> this.facturaRepository.deleteById(p.getConsecutivo_de_facturas()).thenReturn(p));

    }

    @Override
    public Mono<Factura> update(String id, Factura factura) {
        return this.facturaRepository.findById(id)
                .flatMap(factura1 -> {
                    factura.setConsecutivo_de_facturas(id);
                    return save(factura);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Factura> findById(String id) {
        return this.facturaRepository.findById(id);
    }
}
