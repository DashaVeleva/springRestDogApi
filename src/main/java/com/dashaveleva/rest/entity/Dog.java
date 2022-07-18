package com.dashaveleva.rest.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Dog {
    private String name; // 1-100 symbols
    private LocalDate dateOfBirth; // must be before NOW - localdatetime, can be null
    private int height;
    private int weight;


    public Dog() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
