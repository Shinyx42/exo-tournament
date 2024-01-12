package me.guillaume.recruitment.tournament;

public class Figther {
	private Integer m_hitpoint;
	private Integer m_damage;
	
	Figther(int hp, int damage){
		setHitPoint(hp);
		setDamage(damage);
	}

	public Integer hitPoints() {
		return m_hitpoint;
	}

	public void setHitPoint(Integer m_hitpoint) {
		this.m_hitpoint = m_hitpoint;
	}
	
	public void engage(Figther other) {
		other.takeDmg(this.damage());
		if(other.hitPoints()>0) other.engage(this);
	}
	
	private void takeDmg(Integer damage) {
		setHitPoint(hitPoints()-damage);
		if(hitPoints()<0) setHitPoint(0);
		
	}

	public Integer damage() {
		return m_damage;
	}
	
	public void setDamage(int damage) {
		m_damage=damage;
	}
}
