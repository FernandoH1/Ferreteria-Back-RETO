package Ferreteria.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "volantes")
public class Volante {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombreProveedor;

    private Date fecha;

    private String documentoProveedorID;

    private List<Producto> productoList;

    public Volante() {
    }

    public Volante(String id, String nombreProveedor, Date fecha, String documentoProveedorID,  List<Producto> productoList) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.productoList = productoList;
        this.fecha = fecha;
        this.documentoProveedorID = documentoProveedorID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumentoProveedorID() {
        return documentoProveedorID;
    }

    public void setDocumentoProveedorID(String documentoProveedorID) {
        this.documentoProveedorID = documentoProveedorID;
    }

    @Override
    public String toString() {
        return "Volante{" +
                "id='" + id + '\'' +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                ", productoList=" + productoList +
                ", fecha=" + fecha +
                ", documentoProveedorID='" + documentoProveedorID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volante volante = (Volante) o;
        return Objects.equals(id, volante.id) && Objects.equals(nombreProveedor, volante.nombreProveedor) && Objects.equals(productoList, volante.productoList) && Objects.equals(fecha, volante.fecha) && Objects.equals(documentoProveedorID, volante.documentoProveedorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
