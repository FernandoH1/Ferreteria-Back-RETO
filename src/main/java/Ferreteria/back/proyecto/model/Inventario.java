package Ferreteria.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "inventarios")
public class Inventario {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private List<Producto> productoList;

    public Inventario() {
    }

    public Inventario(String id, List<Producto> productoList) {
        this.id = id;
        this.productoList = productoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }


}
