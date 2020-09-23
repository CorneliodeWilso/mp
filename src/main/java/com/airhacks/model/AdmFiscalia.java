package com.airhacks.model;


import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "adm_fiscalia", schema = "public")
public class AdmFiscalia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @NotNull
    @Column(name = "fiscalia_id")
    private Long fiscalia_id;


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

    @Column(name = "swdatecreated")
    @NotNull
    private LocalDateTime swdatecreated;

    public AdmFiscalia() {
    }

    public AdmFiscalia(@NotNull Long fiscalia_id, @Size(max = 250) @NotNull String name, @Size(max = 250) @NotNull String address_line, @NotNull AdmTypology country, @NotNull AdmTypology state, @NotNull AdmTypology city, @NotNull AdmTypology zone, @NotNull Long phone, @NotNull Long phone1, @NotNull LocalDateTime swdatecreated) {
        this.fiscalia_id = fiscalia_id;
        this.name = name;
        this.address_line = address_line;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zone = zone;
        this.phone = phone;
        this.phone = phone1;
        this.swdatecreated = swdatecreated;
    }

    public Long getFiscalia_id() {
        return fiscalia_id;
    }

    public void setFiscalia_id(Long fiscalia_id) {
        this.fiscalia_id = fiscalia_id;
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

    public LocalDateTime getSwdatecreated() {
        return swdatecreated;
    }

    public void setSwdatecreated(LocalDateTime swdatecreated) {
        this.swdatecreated = swdatecreated;
    }

    @Override
    public String toString() {
        return "AdmFiscalia{" +
                "fiscalia_id=" + fiscalia_id +
                ", name='" + name + '\'' +
                ", address_line='" + address_line + '\'' +
                ", country=" + country +
                ", state=" + state +
                ", city=" + city +
                ", zone=" + zone +
                ", phone=" + phone +
                ", phone=" + phone +
                ", swdatecreated=" + swdatecreated +
                '}';
    }
}
