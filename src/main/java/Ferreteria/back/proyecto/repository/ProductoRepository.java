package Ferreteria.back.proyecto.repository;

import Ferreteria.back.proyecto.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto,String> {
}
