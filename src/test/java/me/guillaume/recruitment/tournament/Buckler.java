package me.guillaume.recruitment.tournament;

public class Buckler {
	private Integer life;
	private Integer block;
	
	public Buckler() {
		life = 3;
		block = 0;
	}
	
	public Integer hit(Wepon wepon) {
		int dmg=wepon.hit();
		//System.out.println("life? "+life);
		if(life>=0) {
			if(wepon instanceof Axe) life-=1;
			System.out.println("Block? "+block);
			if(block%2!=0) {
				dmg= 0;
				//System.out.println("Block! "+block);
			}
			block+=1;
		} else {
			//System.out.println("Break!");
		}
		return dmg;
	}

}
