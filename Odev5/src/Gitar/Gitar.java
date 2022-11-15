package Gitar;

public class Gitar implements Playable, Tunable {

	@Override
	public void tune() {
		System.out.println("Tellere basıp akort burgularını sıkarak veya gevşeterek akort edebilirsiniz.");
	}

	@Override
	public void play() {
		System.out.println("Tellere vurarak gitar çalabilirsiniz.");
	}

}
