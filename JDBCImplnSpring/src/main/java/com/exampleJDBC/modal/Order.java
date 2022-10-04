package com.exampleJDBC.modal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="orders_tables")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String orderTrackingNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	
	//TO CREATE ONE TO ONE UNIDIRECTIONAL MAPPING WE HAVE TO CREATE OBJECT OF ADDRESS
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billing_address_id",referencedColumnName = "id")
	private Address billingAddress;
	
	
}
