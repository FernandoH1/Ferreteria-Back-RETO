package Ferreteria.back.proyecto.service.Impl;

import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.model.Volante;
import Ferreteria.back.proyecto.repository.VolanteRepository;
import Ferreteria.back.proyecto.service.ServiceVolante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceVolanteImpl implements ServiceVolante {
    @Autowired
    VolanteRepository volanteRepository;

    @Override
    public Mono<Volante> save(Volante volante) {
        return this.volanteRepository.save(volante);
    }

    @Override
    public Flux<Volante> findAll() {
        return this.volanteRepository.findAll();
    }
}
