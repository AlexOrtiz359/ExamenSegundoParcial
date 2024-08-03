package hn.lenguajes.creditos.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuotas")
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoCuota")
    private Long codigoCuota;

    private Long mes;

    private Double capital;

    private Double saldo;

    private Long codigoPrestamo;

    private Double cuotas;
    
}
