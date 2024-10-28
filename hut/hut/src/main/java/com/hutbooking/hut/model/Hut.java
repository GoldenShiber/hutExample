package com.hutbooking.hut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Hut {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String location;
    private String description;

    Hut(){

    };

    public Hut(String name, String location, String description){
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hut hut = (Hut) o;
        return Objects.equals(id, hut.id) && Objects.equals(name, hut.name) && Objects.equals(location, hut.location) && Objects.equals(description, hut.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, description);
    }

    @Override
    public String toString() {
        return "Hut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
