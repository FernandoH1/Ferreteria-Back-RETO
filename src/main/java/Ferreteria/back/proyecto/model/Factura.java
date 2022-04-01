package Ferreteria.back.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "facturas")
public class Factura {
    @Id
    private String consecutivo_de_facturas = UUID.randomUUID().toString().substring(0, 10);
    private Date fecha;
    private Cliente nombreCliente;
    private String atencionCliente;
    private Double totalPago;
    private List<Producto> productosPagos;


    public Factura() {
    }

    public Factura(String consecutivo_de_facturas, Date fecha, Cliente nombreCliente, String atencionCliente, Double totalPago, List<Producto> productosPagos) {
        this.consecutivo_de_facturas = consecutivo_de_facturas;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.atencionCliente = atencionCliente;
        this.productosPagos = productosPagos;
        this.totalPago = totalPago;
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

    public Cliente getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(Cliente nombreCliente) {
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
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public void calcularPago(){
        for (Producto producto:this.productosPagos) {
            this.totalPago+=producto.getPrecio();
        }
    }

}
