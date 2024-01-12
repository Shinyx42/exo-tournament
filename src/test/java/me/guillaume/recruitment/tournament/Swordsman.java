package me.guillaume.recruitment.tournament;

public class Swordsman extends Figther {

	private int m_vic;

	Swordsman() {
		super(100);
		equipe("sword");
		m_vic=0;
	}

	public Swordsman(String string) {
		this();
		if(string.equals("Vicious")) m_vic = 2;
	}

	public Swordsman equip(String string) {
		equipe(string);
		return this;
	}
	
	@Override
	public void engage(Figther other) {
		m_vic = other.takeDmg(this.m_wepon, m_vic);
		if(other.hitPoints()>0) other.engage(this);
	}
}
