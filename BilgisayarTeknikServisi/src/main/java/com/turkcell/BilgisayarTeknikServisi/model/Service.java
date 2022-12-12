package com.turkcell.BilgisayarTeknikServisi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer desktop;

	@Column
	private Integer laptop;

	@Column
	private Integer mac;

	@Column
	private String name;

	@Column
	private Integer duration;
}
