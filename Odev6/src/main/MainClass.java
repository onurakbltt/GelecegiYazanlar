package main;

public class MainClass {

	public static void main(String[] args) {
		MyReader reader = new MyReader();
		System.out.println(reader
				.readWords("C:\\Developments\\eclipse\\WorkSpace\\GelecegiYazanlar\\Odev6\\src\\main\\deneme.txt"));
		System.out.println(reader.readLineAt(1));
	}

}
