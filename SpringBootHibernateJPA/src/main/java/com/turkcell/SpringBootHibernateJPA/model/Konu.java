package com.turkcell.SpringBootHibernateJPA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "konu")
public class Konu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@Column(length = 200)
	private String NAME;

	@OneToMany(mappedBy = "konu")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Ders> dersler;

	public Konu(String nAME) {
		NAME = nAME;
	}
}
