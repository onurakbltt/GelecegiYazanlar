package com.turkcell.SpringBootRestJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ogrenci {

	private Long ID;

	private String NAME;

	private long OGRNUMBER;

	private long YEAR;

	public Ogrenci(String nAME, long oGRNUMBER, long yEAR) {
		NAME = nAME;
		OGRNUMBER = oGRNUMBER;
		YEAR = yEAR;
	}

}
