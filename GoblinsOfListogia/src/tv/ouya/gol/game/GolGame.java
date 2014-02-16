package tv.ouya.gol.game;

import tv.ouya.gol.Screen;
import tv.ouya.gol.Ouya.OuyaGame;

public class GolGame extends OuyaGame{
	
	BattleScreen battleScreen;

	public GolGame()
	{
		
	}
	@Override
	public Screen getInitScreen() {
		
		if(battleScreen == null)
		{
			battleScreen = new BattleScreen(this);
		}
		// TODO Auto-generated method stub
		return battleScreen;
	}

}
