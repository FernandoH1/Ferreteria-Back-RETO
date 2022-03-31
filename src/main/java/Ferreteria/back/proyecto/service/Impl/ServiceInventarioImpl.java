package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.model.Inventario;
import Ferreteria.back.proyecto.repository.InventarioRepository;
import Ferreteria.back.proyecto.service.ServiceInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceInventarioImpl implements ServiceInventario {
    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public Mono<Inventario> save(Inventario inventario) {
        return this.inventarioRepository.save(inventario);
    }

    @Override
    public Flux<Inventario> findAll() {
        return this.inventarioRepository.findAll();
    }

    @Override
    public Mono<Inventario> delete(String id) {
        return this.inventarioRepository
                .findById(id)
                .flatMap(p -> this.inventarioRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<Inventario> update(String id, Inventario inventario) {
        return this.inventarioRepository.findById(id)
                .flatMap(inventario1 -> {
                    inventario.setId(id);
                    return save(inventario);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Inventario> findById(String id) {
        return this.inventarioRepository.findById(id);
    }
}
