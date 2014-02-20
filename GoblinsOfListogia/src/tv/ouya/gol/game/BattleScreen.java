package tv.ouya.gol.game;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.util.SparseArray;
import tv.ouya.gol.Game;
import tv.ouya.gol.Image;
import tv.ouya.gol.Screen;
import tv.ouya.gol.Ouya.OuyaImage;

public class BattleScreen extends Screen {

	//Graphic assets - only need one of each
	public static Image backgroundImage;
	public static Image backgroundMountains;
	public static Image PlayerSpriteAsset;
	public static Image attackAsset;
	
	ArrayList<Player> Players;
	public BattleScreen(Game game) {
		super(game);

		//Load Background assets
		Bitmap backgroundBitmap = BitmapFactory.decodeResource(((Activity)game).getResources(), R.drawable.battle_background5);
        if(backgroundBitmap==null)
        {
            Log.e("Graphics", "Background Asset failed to load");
        }
        backgroundImage = new OuyaImage(backgroundBitmap);
		Bitmap mountainsBitmap = BitmapFactory.decodeResource(((Activity)game).getResources(), R.drawable.mountains);
        if(mountainsBitmap==null)
        {
            Log.e("Graphics","Background Asset failed to load");
        }
        backgroundMountains = new OuyaImage(mountainsBitmap);
        //Load player asset
        backgroundImage = new OuyaImage(backgroundBitmap);
		Bitmap playerBitmap = BitmapFactory.decodeResource(((Activity)game).getResources(), R.drawable.paladin);
        if(playerBitmap==null)
        {
            Log.e("Graphics","player Asset failed to load");
        }
        PlayerSpriteAsset = new OuyaImage(playerBitmap);
        //Attack asset
		Bitmap attackBitmap = BitmapFactory.decodeResource(((Activity)game).getResources(), R.drawable.slash);
        if(attackBitmap==null)
        {
            Log.e("Graphics","attack Asset failed to load");
        }
        attackAsset = new OuyaImage(attackBitmap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		//Draw each player
		int key = 0;
		SparseArray<Player> currentPlayers = ((GolGame)gameInstance).getPlayers();
		for(int i = 0; i < currentPlayers.size(); i++) {
		   key = currentPlayers.keyAt(i);
		   // get the object by the key.
		   Player p = currentPlayers.get(key);
		   p.Update(deltaTime);
		}
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		//gameInstance.getGraphics().drawImage(backgroundMountains, 0, 0);
		gameInstance.getGraphics().drawImage(backgroundImage, 0, 0);
		
		//Draw each player
		int key = 0;
		SparseArray<Player> currentPlayers = ((GolGame)gameInstance).getPlayers();
		for(int i = 0; i < currentPlayers.size(); i++) {
		   key = currentPlayers.keyAt(i);
		   // get the object by the key.
		   Player p = currentPlayers.get(key);
		   p.DrawPlayer(gameInstance.getGraphics());
		}
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



}
