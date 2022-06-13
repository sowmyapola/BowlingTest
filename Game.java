
public class Game {

	public int roll =0;
	public int[] rolls = new int[21];
	
	public void roll(int...rolls){
		for(int pinDown : rolls){
			roll(pinDown);
		}
	}
	
	public void roll(int pinDown){
		rolls[roll++]=pinDown;
	}
	
	public int score(){
		int score =0;
		int cursor =0;
		
		for(int frame =0; frame<10 ; frame++){
			if(isStrike(cursor)){
			score +=10+rolls[cursor+1]+rolls[cursor+2];
			cursor++;
		}else if(isSpare(cursor)){
			score += 10 + rolls[cursor+2];
			cursor +=2;
		}else{
			score +=rolls[cursor]+ rolls[cursor+1];
			cursor+=2;
		}
	}
		return score;
}
	public boolean isSpare(int cursor){
		return rolls[cursor] + rolls[cursor+1]==10;
	}
	
	public boolean isStrike(int cursor){
		return rolls[cursor] ==10;
	}

	public void canScoreGutterGame(){
		roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		Assert.assertEquals(score(),0);
	}

	public void canScoreGameOfOne(){
		roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
		System.out.println(score());
		Assert.assertEquals(score(),20);
	}

	public void canScoreSpareFollowedByThree(){
		roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

		System.out.println(score());
		Assert.assertEquals(score(),16);
	}


	public void canScoreStrikeFollowedByThreeThenThree(){
		roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		System.out.println(score());
		Assert.assertEquals(score(),22);
	}

	public void canScorePerfectGame(){
		roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10);
		System.out.println(score());
		Assert.assertEquals(score(),300);
	}

	public void problemScoreBoard(){
		roll(1,4, 4,5, 6,4, 5,5 ,10, 0,1, 7,3, 6,4, 10, 2,8,6);
		System.out.println(score());
		Assert.assertEquals(score(),133);
	}
}
	
}
