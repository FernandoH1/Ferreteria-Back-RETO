package Ferreteria.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "facturas")
public class Factura {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String consecutivo_de_facturas;
    private Date fecha;
    private String nombreCliente;
    private String atencionCliente;
    private List<Producto> productosPagos;
    private Double TotalPago;

    public Factura() {
    }

    public Factura(String id, String consecutivo_de_facturas, Date fecha, String nombreCliente, String atencionCliente, List<Producto> productosPagos, Double totalPago) {
        this.id = id;
        this.consecutivo_de_facturas = consecutivo_de_facturas;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.atencionCliente = atencionCliente;
        this.productosPagos = productosPagos;
        TotalPago = totalPago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsecutivo_de_facturas() {
        return consecutivo_de_facturas;
    }

    public void setConsecutivo_de_facturas(String consecutivo_de_facturas) {
        this.consecutivo_de_facturas = consecutivo_de_facturas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAtencionCliente() {
        return atencionCliente;
    }

    public void setAtencionCliente(String atencionCliente) {
        this.atencionCliente = atencionCliente;
    }

    public List<Producto> getProductosPagos() {
        return productosPagos;
    }

    public void setProductosPagos(List<Producto> productosPagos) {
        this.productosPagos = productosPagos;
    }

    public Double getTotalPago() {
        return TotalPago;
    }

    public void setTotalPago(Double totalPago) {
        TotalPago = totalPago;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", consecutivo_de_facturas='" + consecutivo_de_facturas + '\'' +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", atencionCliente='" + atencionCliente + '\'' +
                ", productosPagos=" + productosPagos +
                ", TotalPago=" + TotalPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) && Objects.equals(consecutivo_de_facturas, factura.consecutivo_de_facturas) && Objects.equals(fecha, factura.fecha) && Objects.equals(nombreCliente, factura.nombreCliente) && Objects.equals(atencionCliente, factura.atencionCliente) && Objects.equals(productosPagos, factura.productosPagos) && Objects.equals(TotalPago, factura.TotalPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
