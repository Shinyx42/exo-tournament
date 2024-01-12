package me.guillaume.recruitment.tournament;

public class Highlander extends Figther {

	private boolean m_vet;
	private boolean m_berserk;

	Highlander() {
		super(150);
		equipe("greatsword");
		m_vet = false;
		m_berserk = false;
	}

	public Highlander(String string) {
		this();
		if(string.equals("Veteran")) m_vet = true;
	}
	
	@Override
	public void engage(Figther other) {
		if (m_vet) m_berserk = (hitPoints()<=0.3*150);
		other.takeDmg(this.m_wepon, m_berserk);
		if(other.hitPoints()>0) other.engage(this);
	}
}
