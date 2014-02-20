package tv.ouya.gol.game;

import java.util.ArrayList;
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
	boolean isAttacking;
	final String PlayerName;
	ArrayList<Attack> attacks = new ArrayList<Attack>();
	
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
        	float axisLSX = c.getAxisValue(OuyaController.AXIS_LS_X);
        	float axisLSY = c.getAxisValue(OuyaController.AXIS_LS_Y);
        	
        	float axisRSX = c.getAxisValue(OuyaController.AXIS_RS_X);
        	float axisRSY = c.getAxisValue(OuyaController.AXIS_RS_Y);
        	
        	//move player
            if (OuyaControllUtil.isStickNotCentered(axisLSX,axisLSY)) {
            	//Log.d("Player","Moving Player");
            	position.add(new Vector2((int)(axisLSX*3*deltatime), (int)(axisLSY*3*deltatime)));
            }
            //check for right stick attack
            if(OuyaControllUtil.stickMag(axisRSX, axisRSY)>0.6f)
            {
            	if(!isAttacking)
            	{
            		Log.d("Player","Attacked");
            		isAttacking=true;
            		float attackPositionX = axisRSX * 10;
            		float attackPositionY = axisRSY * 10;
            	}
            }
            else if(isAttacking)
            {
            	isAttacking = false;
            }
        }
	}
	public void DrawPlayer(Graphics graphicsProvider)
	{
		graphicsProvider.drawImage(playerSprite.getSprite(), position.x+offset.x, position.y+offset.y);
		graphicsProvider.drawString(PlayerName, position.x+offset.x, position.y-20+offset.y, new TextPaint());
	}
}
