package Ferreteria.back.proyecto.repository;

import Ferreteria.back.proyecto.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente,String> {
}
