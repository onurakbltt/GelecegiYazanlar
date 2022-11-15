package Main.Kulaklik;

public class KabloluKulaklik extends Kulaklik {
	private int kabloUzunlugu;
	private Boolean kulaklikJakiTakiliMi;

	@Override
	public void dinle() {
		if (kulaklikJakiTakiliMi) {
			System.out.println("Kulaklık jakı takılı. Müziğin keyfini çıkartabilirsin.");
		} else {
			System.out.println("müzik dinlemek istiyorsanız kulaklık jakını takınız!");
		}
	}

	@Override
	public void konus() {
		if (super.mikrofonVarMi) {
			if (kulaklikJakiTakiliMi) {
				System.out.println("Kulaklık jakı takılı konuşabilirsin");
			} else {
				System.out.println("Konuşmak için jakı takın");
			}
		} else {
			System.out.println("Konuşamazsınız.");
		}
	}

	public int getKabloUzunlugu() {
		return kabloUzunlugu;
	}

	public void setKabloUzunlugu(int kabloUzunlugu) {
		this.kabloUzunlugu = kabloUzunlugu;
	}

	public Boolean getKulaklikJakiTakiliMi() {
		return kulaklikJakiTakiliMi;
	}

	public void setKulaklikJakiTakiliMi(Boolean kulaklikJakiTakiliMi) {
		this.kulaklikJakiTakiliMi = kulaklikJakiTakiliMi;
	}
}
