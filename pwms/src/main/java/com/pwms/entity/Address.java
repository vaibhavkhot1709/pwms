package com.pwms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="pwAddress")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addId;


    private int floorNo;
    private int flatNo;
    

    @NotNull(message = "Building name should not be NULL")
    private String buildingName;
    @NotNull(message = "PIN Numb should not be NULL")
    private int pinNum;
}
