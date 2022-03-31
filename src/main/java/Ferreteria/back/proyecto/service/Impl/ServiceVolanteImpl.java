package Ferreteria.back.proyecto.service.Impl;

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

    @Override
    public Mono<Volante> delete(String id) {
        return this.volanteRepository
                .findById(id)
                .flatMap(p -> this.volanteRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<Volante> update(String id, Volante volante) {
        return this.volanteRepository.findById(id)
                .flatMap(volante1 -> {
                    volante.setId(id);
                    return save(volante);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Volante> findById(String id) {
        return this.volanteRepository.findById(id);
    }
}
