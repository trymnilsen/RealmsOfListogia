package tv.ouya.gol.game;

import tv.ouya.gol.Graphics;
import tv.ouya.gol.Vector2;

public class Attack extends DrawAsset{

	private static float lifeTime = 2000;
	public long currentTime;
	Vector2 position; 
	public Attack()
	{
		super(BattleScreen.attackAsset);
		currentTime = System.nanoTime();
	}
	public void Draw(Graphics graphicsProvider)
	{
		graphicsProvider.drawImage(sprite, position.x, position.y);
	}
}
