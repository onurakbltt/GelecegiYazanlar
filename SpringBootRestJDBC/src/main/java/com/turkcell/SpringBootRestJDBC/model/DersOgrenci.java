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
public class DersOgrenci {

	private long ID;

	private int DEVAMSIZLIK;

	private long NOTE;

	private long DERS_ID;

	private long OGR_ID;

	public DersOgrenci(int dEVAMSIZLIK, long nOTE, long dERS_ID, long oGR_ID) {
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
		DERS_ID = dERS_ID;
		OGR_ID = oGR_ID;
	}

}
