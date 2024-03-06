package org.uv.dapp02practica01;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; // Add import for JoinColumn
import javax.persistence.ManyToOne; // Add import for ManyToOne
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Codigy
 */
@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {
     @Id
    @Column(name="idlinea")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "detalleventa_idlinea_seq")
    @SequenceGenerator(name = "detalleventa_idlinea_seq",
            sequenceName = "detalleventa_idlinea_seq",
            initialValue = 1,
            allocationSize = 1)
     
    private long id;    
    @Column
    private double cantidad;    
    @Column
    private double precio;    
    @Column
    private String producto;
    @ManyToOne
    @JoinColumn(name="idventa")
    private Venta venta;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
