package Ferreteria.back.proyecto.repository;

import Ferreteria.back.proyecto.model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolanteRepository extends ReactiveMongoRepository<Volante,String> {
}
