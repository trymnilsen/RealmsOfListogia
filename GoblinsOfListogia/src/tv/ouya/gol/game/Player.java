package tv.ouya.gol.game;

import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextPaint;
import android.util.Log;
import tv.ouya.console.api.OuyaController;
import tv.ouya.gol.Graphics;
import tv.ouya.gol.Image;
import tv.ouya.gol.Vector2;
import tv.ouya.gol.Ouya.OuyaControllUtil;
import tv.ouya.gol.Ouya.OuyaImage;

public class Player {
	
	SpriteSheet playerSprite;
	boolean isPlayable = true;
	int playerNr;
	Vector2 position;
	Vector2 offset;
	final String PlayerName;
	
	public Player(int playerNr)
	{
		Random r = new Random(System.nanoTime());
		playerSprite = new SpriteSheet(BattleScreen.PlayerSpriteAsset,30,10);
		position = new Vector2(960,540);
		offset = new Vector2(r.nextInt(100),r.nextInt(100));
		PlayerName = "Hero "+playerNr;
	}
	public boolean isValid()
	{
		return isPlayable;
	}
	public void Update(float deltatime)
	{
		OuyaController c = OuyaController.getControllerByPlayer(playerNr);
        if (c != null) {
        	float axisX = c.getAxisValue(OuyaController.AXIS_LS_X);
        	float axisY = c.getAxisValue(OuyaController.AXIS_LS_Y);
        	
            if (OuyaControllUtil.isStickNotCentered(axisX,axisY)) {
            	//Log.d("Player","Moving Player");
            	position.add(new Vector2((int)(axisX*3*deltatime), (int)(axisY*3*deltatime)));
            }
        }
	}
	public void DrawPlayer(Graphics graphicsProvider)
	{
		graphicsProvider.drawImage(playerSprite.getSprite(), position.x+offset.x, position.y+offset.y);
		graphicsProvider.drawString(PlayerName, position.x+offset.x, position.y-20+offset.y, new TextPaint());
	}
}
