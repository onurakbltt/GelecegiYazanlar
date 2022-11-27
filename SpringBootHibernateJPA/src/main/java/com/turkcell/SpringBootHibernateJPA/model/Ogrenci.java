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
@Table(name = "ogrenci")
public class Ogrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	private String NAME;

	@Column(unique = true)
	private long OGRNUMBER;

	private long YEAR;

	@OneToMany(mappedBy = "ogrenci")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<DersOgrenci> dersOgrenciler;

	public Ogrenci(String nAME, long oGRNUMBER, long yEAR) {
		NAME = nAME;
		OGRNUMBER = oGRNUMBER;
		YEAR = yEAR;
	}

}
