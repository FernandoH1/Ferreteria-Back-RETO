package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.model.Cliente;
import Ferreteria.back.proyecto.repository.ClienteRepository;
import Ferreteria.back.proyecto.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceClienteImpl implements ServiceCliente {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Flux<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Mono<Cliente> delete(String id) {
        return this.clienteRepository
                .findById(id)
                .flatMap(p -> this.clienteRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<Cliente> update(String id, Cliente cliente) {
        return this.clienteRepository.findById(id)
                .flatMap(cliente1 -> {
                    cliente.setId(id);
                    return save(cliente);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Cliente> findById(String id) {
        return this.clienteRepository.findById(id);
    }


}
