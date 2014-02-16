package tv.ouya.gol.game;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import tv.ouya.gol.Game;
import tv.ouya.gol.Image;
import tv.ouya.gol.Screen;
import tv.ouya.gol.Ouya.OuyaImage;

public class BattleScreen extends Screen {

	//Graphic assets
	Image backgroundImage;
	
	ArrayList<Player> Players;
	public BattleScreen(Game game) {
		super(game);

		//Load Background image
		Bitmap backgroundBitmap = BitmapFactory.decodeResource(((Activity)game).getResources(), R.drawable.battle_background);
        if(backgroundBitmap==null)
        {
            Log.e("Graphics", "AAAOOOOOOOOGGGGGGGGGGGGGGGGGAAAAAAAAAAAAAAAH");
        }
        backgroundImage = new OuyaImage(backgroundBitmap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		gameInstance.getGraphics().drawImage(backgroundImage, 0, 0);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub
		
	}

}
