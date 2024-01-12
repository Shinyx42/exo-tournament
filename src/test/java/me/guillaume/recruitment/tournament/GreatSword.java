package me.guillaume.recruitment.tournament;

public class GreatSword extends Wepon {
	private Integer cmp;

	public GreatSword() {
		super(12);
		cmp = 0;
	}
	
	@Override
	public Integer hit(Boolean armored) {
		int dmg = damage();
		if(armored) dmg= damage()<3? 0 : damage()-3;
		if(cmp % 3 == 2) dmg =0;
		cmp +=1;
		//System.out.println(dmg);
		return dmg;
	}
}
