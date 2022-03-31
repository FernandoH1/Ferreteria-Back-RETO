package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.model.Volante;
import Ferreteria.back.proyecto.service.Impl.ServiceVolanteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class VolanteController {
    @Autowired
    private ServiceVolanteImpl serviceVolante;

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Volante> saveVolantes(@RequestBody Volante volante) {
        return this.serviceVolante.save(volante);
    }

    @GetMapping(value = "/volante")
    private Flux<Volante> allVolantes() {
        return this.serviceVolante.findAll();
    }

    @DeleteMapping("/delete/volante/{id}")
    private Mono<ResponseEntity<Volante>> deleteVolante(@PathVariable("id") String id) {
        return this.serviceVolante.delete(id)
                .flatMap(Volante -> Mono.just(ResponseEntity.ok(Volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/edit/volante/{id}")
    private Mono<ResponseEntity<Volante>> updateVolante(@PathVariable("id") String id, @RequestBody Volante volante) {
        return this.serviceVolante.update(id, volante)
                .flatMap(volante1 -> Mono.just(ResponseEntity.ok(volante1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/search/volante/{id}")
    private Mono<Volante> searchVolanteByID(@PathVariable("id") String id) {
        return this.serviceVolante.findById(id);
    }
}
