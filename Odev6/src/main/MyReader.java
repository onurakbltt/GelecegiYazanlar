package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MyReader {
	private FileReader fReader;
	private BufferedReader bReader;
	private String path;
	private ArrayList<String> kelimeler;

	public ArrayList<String> readWords(String path) {
		try {
			this.path = path;
			this.fReader = new FileReader(this.path);
			this.bReader = new BufferedReader(fReader);

			this.kelimeler = new ArrayList<>();
			String satir = this.bReader.readLine();
			while (satir != null) {
				splitLine(satir);
				satir = this.bReader.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error Occured in ReadWords method: " + e.getMessage());
		}
		return this.kelimeler;
	}

	public String readLineAt(int index) {
		String satir = "";
		try {
			this.fReader = new FileReader(this.path);
			this.bReader = new BufferedReader(fReader);
			for (int i = 0; i < index; i++) {
				satir = this.bReader.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error Occurred in ReadLineAt Method: " + e.getMessage());
		}
		return satir;
	}

	private void splitLine(String satir) {
		try {
			for (int i = 0; i < satir.length(); i++) {
				if (Character.isLetter(satir.charAt(i))) {
					String kelime = "";
					while (Character.isLetter(satir.charAt(i))) {
						kelime += satir.charAt(i);
						i++;
					}
					this.kelimeler.add(kelime);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
