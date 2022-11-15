package Main.Kulaklik;

public class Kulaklik {
	private String renk;
	private String marka;
	private String modelNumarasi;
	private int agirlik;
	protected Boolean mikrofonVarMi;

	public void dinle() {
		System.out.println("Müzik dinleyebilirsiniz!!!");
	}

	public void konus() {
		if (mikrofonVarMi) {
			System.out.println("Konuşabilirsiniz");
		}
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModelNumarasi() {
		return modelNumarasi;
	}

	public void setModelNumarasi(String modelNumarasi) {
		this.modelNumarasi = modelNumarasi;
	}

	public int getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(int agirlik) {
		this.agirlik = agirlik;
	}

	public Boolean getMikrofonVarMi() {
		return mikrofonVarMi;
	}

	public void setMikrofonVarMi(Boolean mikrofonVarMi) {
		this.mikrofonVarMi = mikrofonVarMi;
	}

}
