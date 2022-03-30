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


}
