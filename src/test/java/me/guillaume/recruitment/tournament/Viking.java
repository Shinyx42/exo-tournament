package me.guillaume.recruitment.tournament;

public class Viking extends Figther {

	Viking() {
		super(120);
		equipe("axe");
	}

	public Viking equip(String string) {
		equipe(string);
		return this;
	}

}
