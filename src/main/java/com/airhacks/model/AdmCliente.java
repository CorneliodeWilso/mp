package com.airhacks.model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


//lo que hacemos aqui es decirle a JPA que va,mos a utilizar la tabla llamda adm_cliente
@Entity
@Table(name="adm_cliente", schema = "dbo")

//Con esta instruccion lo que hacemos es decirle a Jpa que vamos a retornar un json con el siguiente formato.
@JsonbPropertyOrder({
        "cliente_id", "name", "primer_apellido", "segundo_apellido", "dpi"
})

//dado que nuesto id de la tabla cliente es un autoincrementable, debemos decirle a jpa de cuanto en cuanto va ir incrementando el valor del id autoincremental
//el nombre puede ser cualquiera dado que solo se utiliza como referencia
@SequenceGenerator(
        name = "admClienteSequence",
        sequenceName = "adm_cliente_sequence",
        initialValue = 1,
        allocationSize = 1


)
public class AdmCliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admClienteSequence")
    @NotNull
    @Column(name = "cliente_id")
    private Long cliente_id;

    @Column(name = "name")
    @Size(max = 250)
    @NotNull
    private String name;

    @Column(name = "primer_apellido")
    @Size(max = 100)
    @NotNull
    private String primer_apellido;

    @Column(name = "segundo_apellido")
    @Size(max = 100)
    @NotNull
    private String segundo_apellido;

    @Column(name = "dpi")
    @Size(max = 100)
    @NotNull
    private Long dpi;


    public AdmCliente() {

    }

    public AdmCliente(@NotNull Long cliente_id, @Size(max = 250) @NotNull String name, @Size(max = 250) @NotNull String primer_apellido, @Size(max = 100) @NotNull String segundo_apellido, @Size(max = 100) @NotNull Long dpi) {
        this.cliente_id = cliente_id;
        this.name = name;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.dpi = dpi;
    }

    //metodos get y set para cada propiedad de la tabbla

    public Long getCliente_id() {return cliente_id;}
    public void setCliente_id() {this.cliente_id = cliente_id;}

    public String getName() {return name;}
    public void setName() {this.name = name;}

    public String getPrimer_apellido() {return primer_apellido;}
    public void setPrimer_apellido() {this.primer_apellido = primer_apellido;}


    public String getSegundo_apellido() {return segundo_apellido;}
    public void setSegundo_apellido() {this.segundo_apellido = segundo_apellido;}


    public Long getDpi() {return dpi;}
    public void setDpi() {this.cliente_id = dpi;}


    @Override
    public String toString() {
        return "AdmCliente {" +
                "cliente_id" + cliente_id +
                ", name" + name+
                ", primer_apellido" + primer_apellido +
                ", segundo_apellido" +segundo_apellido +
                ", dpi" + dpi +
                "}";
    }

}