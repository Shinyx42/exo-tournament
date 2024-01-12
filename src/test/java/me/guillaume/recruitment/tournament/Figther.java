package me.guillaume.recruitment.tournament;

public class Figther {
	private Integer m_hitpoint;
	private Wepon m_wepon;
	private Buckler m_buckler;
	
	Figther(int hp){
		setHitPoint(hp);
		m_wepon = null;
		m_buckler = null;
	}

	public Integer hitPoints() {
		return m_hitpoint;
	}

	public void setHitPoint(Integer m_hitpoint) {
		this.m_hitpoint = m_hitpoint;
	}
	
	public void engage(Figther other) {
		other.takeDmg(this.m_wepon);
		if(other.hitPoints()>0) other.engage(this);
	}
	
	private void takeDmg(Wepon wepon) {
		if(m_buckler == null) setHitPoint(hitPoints()-wepon.hit());
		else setHitPoint(hitPoints()-m_buckler.hit(wepon));
		if(hitPoints()<0) setHitPoint(0);
		//System.out.println(m_hitpoint);
		
	}

	public Integer damage() {
		return m_wepon.damage();
	}
	
	protected void equipe(String eqpmnt) {
		if(eqpmnt.equals("axe")) {
			m_wepon = new Axe();
		}
		if(eqpmnt.equals("sword")) {
			m_wepon = new Sword();
		}
		if(eqpmnt.equals("buckler")) {
			m_buckler = new Buckler();
		}
	}
}
