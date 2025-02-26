package com.pwms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="studentsData")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stdId;
	
	 @Column(nullable = false)
	 @NotBlank(message = "First name should not be Blanck")
	 @NotEmpty(message = "First name should not be Empty")
	 @NotNull(message = "First name should not be NULL")
	private String firstName;
	 
	 @NotBlank(message = "First name should not be Blanck")
	 @NotEmpty(message = "First name should not be Empty")
	 @NotNull(message = "Last name should not be NULL")
	private String lastName;
	private String email;
	
	@NotNull(message = "Contact should not be NULL")
	private String contct;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id", referencedColumnName = "addId")
	private Address address;

}

