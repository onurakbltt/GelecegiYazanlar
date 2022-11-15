import java.util.LinkedList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LinkedList<Character> liste = new LinkedList<>();
		System.out.print("Metin giriniz: ");
		String metin = scn.nextLine();
		int[] count = new int[metin.length()];

		for (int i = 0; i < metin.length(); i++) {
			if (!liste.contains(metin.charAt(i))) {
				liste.add(metin.charAt(i));
			}
		}

		for (int i = 0; i < metin.length(); i++) {
			int index = liste.indexOf(metin.charAt(i));

			if (index < 0)
				continue;

			count[index]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] < 1)
				continue;

			System.out.print(String.format("%s%d", liste.get(i), count[i]));
		}
		scn.close();
	}

}
