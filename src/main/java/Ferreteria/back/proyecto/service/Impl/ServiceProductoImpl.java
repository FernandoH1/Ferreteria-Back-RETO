package Ferreteria.back.proyecto.service.Impl;


import Ferreteria.back.proyecto.model.Producto;
import Ferreteria.back.proyecto.repository.ProductoRepository;
import Ferreteria.back.proyecto.service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceProductoImpl implements ServiceProducto {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Mono<Producto> save(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public Flux<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Mono<Producto> delete(String id) {
        return this.productoRepository
                .findById(id)
                .flatMap(p -> this.productoRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<Producto> update(String id, Producto producto) {
        return this.productoRepository.findById(id)
                .flatMap(cliente1 -> {
                    producto.setId(id);
                    return save(producto);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Producto> findById(String id) {
        return this.productoRepository.findById(id);
    }
}
