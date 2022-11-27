package com.turkcell.SpringBootHibernateJPA.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
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
@Check(constraints = "NOTE < 101")
@Table(name = "ders_ogrenci")
public class DersOgrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "OGRENCI_FK"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ogrenci ogrenci;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "DERS_FK"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ders ders;

	private int DEVAMSIZLIK;

	private long NOTE;

	public DersOgrenci(Ogrenci ogrenci, Ders ders, int dEVAMSIZLIK, long nOTE) {
		this.ogrenci = ogrenci;
		this.ders = ders;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}

}
