package com.turkcell.BilgisayarTeknikServisi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.security.core.GrantedAuthority;

//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Role // implements GrantedAuthority
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @Column(nullable = false)
	private String name;

	// @Override
	public String getAuthority() {

		return name;
	}

}
