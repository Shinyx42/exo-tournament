package me.guillaume.recruitment.tournament;

public class Wepon {
	private Integer m_damage;
	
	public Wepon(int dmg) {
		m_damage = dmg;
	}
	
	public Integer damage() {
		return m_damage;
	}

	public Integer hit(Boolean armored) {
		if(armored) return m_damage<3? 0 : m_damage-3;
		else return m_damage;
	}

	public void Armored() {
		m_damage -=1;
		
	}

}
