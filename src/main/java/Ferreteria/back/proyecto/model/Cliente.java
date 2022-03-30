package Ferreteria.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;

    private String celular;

    private String documentoID;

    public Cliente() {
    }

    public Cliente(String id, String nombre, String celular, String documentoID) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.documentoID = documentoID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumentoID() {
        return documentoID;
    }

    public void setDocumentoID(String documentoID) {
        this.documentoID = documentoID;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", documentoID='" + documentoID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(celular, cliente.celular) && Objects.equals(documentoID, cliente.documentoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
