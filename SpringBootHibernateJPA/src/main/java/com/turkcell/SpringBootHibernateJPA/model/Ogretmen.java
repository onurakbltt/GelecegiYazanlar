package com.turkcell.SpringBootHibernateJPA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ogretmen")
public class Ogretmen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@Column(length = 100)
	private String NAME;

	private boolean ISGICIK;

	@OneToMany(mappedBy = "ogretmen", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Ders> dersler;

	public Ogretmen(String nAME, boolean iSGICIK) {
		NAME = nAME;
		ISGICIK = iSGICIK;
	}

}
