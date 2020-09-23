package com.airhacks.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;


@Entity
@Table(name = "adm_typology", schema = "public")
public class AdmTypology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(name = "typology_id")
    private Long typology_id;


    @Column(name = "description")
    @Size(max = 200)
    @NotNull
    private String description;


    @Column(name = "parent_typology_id")
    @DefaultValue("0")
    @NotNull
    private Long parent;

    public AdmTypology() {
    }

    public AdmTypology(@NotNull Long typology_id, @Size(max = 200) @NotNull String description, @NotNull Long parent) {
        this.typology_id = typology_id;
        this.description = description;
        this.parent = parent;
    }

    public Long getTypology_id() {
        return typology_id;
    }

    public void setTypology_id(Long typology_id) {
        this.typology_id = typology_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "AdmTypology{" +
                "typology_id=" + typology_id +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                '}';
    }
}
