package com.turkcell.SpringBootHibernateJPA.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ders")
public class Ders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ogretmen ogretmen;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Konu konu;

	@OneToMany(mappedBy = "ders", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<DersOgrenci> dersOgrenciler;

	public Ders(Ogretmen ogretmen, Konu konu) {
		this.ogretmen = ogretmen;
		this.konu = konu;
	}

}
