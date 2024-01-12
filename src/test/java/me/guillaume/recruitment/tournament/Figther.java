package me.guillaume.recruitment.tournament;

public class Figther {
	private Integer m_hitpoint;
	protected Wepon m_wepon;
	private Buckler m_buckler;
	private Boolean m_armored;
	
	Figther(int hp){
		setHitPoint(hp);
		m_wepon = null;
		m_buckler = null;
		m_armored = false;
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
	
	protected void takeDmg(Wepon wepon) {
		if(m_buckler == null) setHitPoint(hitPoints()-wepon.hit(m_armored));
		else setHitPoint(hitPoints()-m_buckler.hit(wepon, m_armored));
		if(hitPoints()<0) setHitPoint(0);
		//System.out.println(m_hitpoint);
		
	}
	
	protected int takeDmg(Wepon wepon, int vic) {
		int hit=0;
		if(m_buckler == null) hit = wepon.hit(m_armored);
		else hit = m_buckler.hit(wepon, m_armored);
		
		if(vic>0 && hit>0) {
			hit +=20;
			vic -=1;
		}
		
		setHitPoint(hitPoints()-hit);
		if(hitPoints()<0) setHitPoint(0);
		System.out.println(m_hitpoint);
		return vic;
		
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
		if(eqpmnt.equals("greatsword")) {
			m_wepon = new GreatSword();
		}
		if(eqpmnt.equals("armor")) {
			m_armored = true;
			m_wepon.Armored();
		}
		
	}

	public void takeDmg(Wepon wepon, boolean berserk) {
		if(m_buckler == null) setHitPoint(hitPoints()-wepon.hit(m_armored));
		else setHitPoint(hitPoints()-m_buckler.hit(wepon, m_armored)*(berserk? 2:1));
		if(hitPoints()<0) setHitPoint(0);
		
	}
}
