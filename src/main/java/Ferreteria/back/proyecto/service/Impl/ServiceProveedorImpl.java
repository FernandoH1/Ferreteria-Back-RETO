package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.repository.ProveedorRepository;
import Ferreteria.back.proyecto.service.ServiceProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceProveedorImpl implements ServiceProveedor {
    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public Mono<Proveedor> save(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    @Override
    public Flux<Proveedor> findAll() {
        return this.proveedorRepository.findAll();
    }
}
