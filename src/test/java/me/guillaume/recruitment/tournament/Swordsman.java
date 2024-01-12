package me.guillaume.recruitment.tournament;

public class Swordsman extends Figther {

	Swordsman() {
		super(100);
		equipe("sword");
	}

	public Swordsman equip(String string) {
		equipe(string);
		return this;
	}
	

}
