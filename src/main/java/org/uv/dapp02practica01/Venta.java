package org.uv.dapp02practica01;

import java.io.Serializable;
import java.util.ArrayList;  // Add import for ArrayList
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * author Codigy
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
@Id
    @Column(name="idventa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "venta_idventa_seq")
    @SequenceGenerator(name = "venta_idventa_seq",
            sequenceName = "venta_idventa_seq",
            initialValue = 1,
            allocationSize = 1)
    private long id;
    @Column
    private java.sql.Date fecha;
    @Column
    private String cliente;
    @Column
    private double total;
    public long getId() {
        return id;
    }

    @OneToMany (mappedBy = "venta", fetch = FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;
    
    public Venta(){
        detalleVenta = new ArrayList<>();
    }
    
    public List<DetalleVenta> getDetalleVenta(){
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }    
            
    public void setId(long id) {
        this.id = id;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
