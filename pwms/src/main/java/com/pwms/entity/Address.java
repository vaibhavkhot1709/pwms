package com.pwms.entity;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @NotBlank
    @NotEmpty
    private String buildingName;
    
    @NotBlank
    @NotEmpty
    @NotNull(message = "PIN Numb should not be NULL")
    private int pinNum;
}
