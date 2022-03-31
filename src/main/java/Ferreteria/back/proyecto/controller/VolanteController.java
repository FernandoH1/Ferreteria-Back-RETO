package Ferreteria.back.proyecto.controller;

import Ferreteria.back.proyecto.model.Proveedor;
import Ferreteria.back.proyecto.model.Volante;
import Ferreteria.back.proyecto.service.Impl.ServiceVolanteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
