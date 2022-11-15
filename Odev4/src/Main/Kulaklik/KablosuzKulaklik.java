package Main.Kulaklik;

public class KablosuzKulaklik extends Kulaklik {
	private Boolean sarjiVarMi;
	private Boolean bluetoothBagliMi;

	@Override
	public void dinle() {
		if (sarjiVarMi) {
			if (bluetoothBagliMi) {
				System.out.println("Kulaklığın şarjı ve bluetooth bağlantısı var. Müziğin keyfini çıkartabilirsin.");
			} else {
				System.out.println("Lütfen bluetooth bağlantısını kontrol edin.");
			}
		} else {
			System.out.println("Lütfen kulaklığı şarj edin.");
		}
	}

	@Override
	public void konus() {
		if (super.mikrofonVarMi) {
			if (sarjiVarMi) {
				if (bluetoothBagliMi) {
					System.out.println("Kulaklığın şarjı ve bluetooth bağlantısı var. Konuşabilirsiniz.");
				} else {
					System.out.println("Lütfen bluetooth bağlantısını kontrol edin.");
				}
			} else {
				System.out.println("Lütfen kulaklığı şarj edin.");
			}
		} else {
			System.out.println("Konuşamazsınız.");
		}
	}

	public void sarjEt() {
		if (!sarjiVarMi) {
			System.out.println("Kulaklığı kullanmak için lütfen şarj ediniz.");
		}
	}

	public Boolean getSarjiVarMi() {
		return sarjiVarMi;
	}

	public void setSarjiVarMi(Boolean sarjiVarMi) {
		this.sarjiVarMi = sarjiVarMi;
	}

	public Boolean getBluetoothBagliMi() {
		return bluetoothBagliMi;
	}

	public void setBluetoothBagliMi(Boolean bluetoothBagliMi) {
		this.bluetoothBagliMi = bluetoothBagliMi;
	}

}
