package com.airhacks.model;


import com.airhacks.dto.AdmFiscaliaDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;


import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;


@Entity
@Table(name = "adm_fiscalia", schema = "dbo")
@JsonbPropertyOrder({
        "fiscaliaId", "name", "address_line", "country", "state","city","zone","phone","phone_2"
})

@SequenceGenerator(
        name = "admTypologySequence",
        sequenceName = "adm_typology_sequence",
        initialValue =  1,
        allocationSize = 1
)

@SqlResultSetMapping(
        name = "admfiscaliadto",
        classes =  @ConstructorResult(
                targetClass = AdmFiscaliaDto.class,
                columns = {
                        @ColumnResult(name = "fiscalia_id",type = Long.class),
                        @ColumnResult(name = "name",type = String.class)
                }
        )
)

public class AdmFiscalia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admTypologySequence")
    @NotNull
    @Column(name = "fiscalia_id")
    private Long fiscaliaId;


    @Column(name = "name")
    @Size(max = 250)
    @NotNull
    private String name;

    @Column(name = "address_line")
    @Size(max = 250)
    @NotNull
    private String address_line;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country")
    @NotNull
    @JoinFetch(value = JoinFetchType.INNER)
    private AdmTypology country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state")
    @NotNull
    @JoinFetch(value = JoinFetchType.INNER)
    private AdmTypology state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city")
    @NotNull
    @JoinFetch(value = JoinFetchType.INNER)
    private AdmTypology city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone")
    @NotNull
    @JoinFetch(value = JoinFetchType.INNER)
    private AdmTypology zone;

    @Column(name = "phone")
    @NotNull
    @DefaultValue("0")
    private Long phone;

    @Column(name = "phone_2")
    @NotNull
    @DefaultValue("0")
    private Long phone_2;




    public AdmFiscalia() {
    }

    public AdmFiscalia(Long fiscaliaId, String name) {
        this.fiscaliaId = fiscaliaId;
        this.name = name;
    }

    public AdmFiscalia(@NotNull Long fiscaliaId, @Size(max = 250) @NotNull String name, @Size(max = 250) @NotNull String address_line, @NotNull AdmTypology country, @NotNull AdmTypology state, @NotNull AdmTypology city, @NotNull AdmTypology zone, @NotNull Long phone, @NotNull Long phone_2) {
        this.fiscaliaId = fiscaliaId;
        this.name = name;
        this.address_line = address_line;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zone = zone;
        this.phone = phone;
        this.phone_2 = phone_2;
    }

    public Long getFiscaliaId() {
        return fiscaliaId;
    }

    public void setFiscaliaId(Long fiscaliaId) {
        this.fiscaliaId = fiscaliaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public AdmTypology getCountry() {
        return country;
    }

    public void setCountry(AdmTypology country) {
        this.country = country;
    }

    public AdmTypology getState() {
        return state;
    }

    public void setState(AdmTypology state) {
        this.state = state;
    }

    public AdmTypology getCity() {
        return city;
    }

    public void setCity(AdmTypology city) {
        this.city = city;
    }

    public AdmTypology getZone() {
        return zone;
    }

    public void setZone(AdmTypology zone) {
        this.zone = zone;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(Long phone_2) {
        this.phone_2 = phone_2;
    }



    @Override
    public String toString() {
        return "AdmFiscalia{" +
                "fiscaliaId=" + fiscaliaId +
                ", name='" + name + '\'' +
                ", address_line='" + address_line + '\'' +
                ", country=" + country +
                ", state=" + state +
                ", city=" + city +
                ", zone=" + zone +
                ", phone=" + phone +
                ", phone_2=" + phone_2 +
                '}';
    }
}
