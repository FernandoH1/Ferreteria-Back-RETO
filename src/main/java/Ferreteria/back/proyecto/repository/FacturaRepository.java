package Ferreteria.back.proyecto.repository;

import Ferreteria.back.proyecto.model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura,String> {
}
