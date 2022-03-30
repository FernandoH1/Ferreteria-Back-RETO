package Ferreteria.back.proyecto.repository;

import Ferreteria.back.proyecto.model.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends ReactiveMongoRepository<Inventario,String> {
}
