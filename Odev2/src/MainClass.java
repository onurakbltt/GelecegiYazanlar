import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<Character> liste = new ArrayList<>();
		System.out.print("Metin giriniz: ");
		String metin = scn.nextLine();
		metin = metin.replace(" ", "");
		for (int i = 0; i < metin.length(); i++) {
			if (!liste.contains(metin.charAt(i))) {
				liste.add(metin.charAt(i));
			}
		}
		for (Character character : liste) {
			System.out.print(character);
		}
		scn.close();
	}
}
