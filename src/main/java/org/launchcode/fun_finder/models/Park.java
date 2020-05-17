package org.launchcode.fun_finder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;

@Entity
public class Park {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=150)
    private String name;

    @NotNull
    @Size(min=1, max=100)
    private String address;

    @NotNull
    @Size(min=1, max=15)
    private String zipCode;

    public Park(String name, String address, String zipCode) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
    }

    public Park() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
