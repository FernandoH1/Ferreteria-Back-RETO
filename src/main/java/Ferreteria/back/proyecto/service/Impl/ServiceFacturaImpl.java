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
}
