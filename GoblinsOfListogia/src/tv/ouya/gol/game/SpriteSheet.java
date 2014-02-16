package tv.ouya.gol.game;

import tv.ouya.gol.Image;

public class SpriteSheet {
	public int frames;
	Image sprite;
	public SpriteSheet(Image sprite, int frames){
		this.sprite = sprite;
		this.frames = frames;
	}
}
