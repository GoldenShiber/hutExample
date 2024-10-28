package com.hutbooking.hut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Booking {

    private @Id
    @GeneratedValue Long id;

    private Timestamp startDate;
    private Timestamp endDate;
    private Long customerId;
    private Long hutId;

    public Booking(){

    }
    public Booking(Timestamp startDate, Timestamp endDate, Long customerId, Long hutId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.hutId = hutId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getHutId() {
        return hutId;
    }

    public void setHutId(Long hutId) {
        this.hutId = hutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate) && Objects.equals(customerId, booking.customerId) && Objects.equals(hutId, booking.hutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, customerId, hutId);
    }


}
